package org.intellij.plugins.ceylon.action;

import java.util.Properties;
import java.util.regex.Pattern;

import org.intellij.plugins.ceylon.psi.stub.ModuleIndex;
import org.jetbrains.annotations.Nullable;
import org.mustbe.consulo.roots.ContentFolderScopes;
import org.mustbe.consulo.roots.impl.ProductionContentFolderTypeProvider;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.ide.fileTemplates.FileTemplateUtil;
import com.intellij.ide.util.DirectoryUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.ui.InputValidatorEx;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.GlobalSearchScope;

@org.consulo.lombok.annotations.Logger
public class CeylonAddModule extends AnAction
{
	@Override
	public void actionPerformed(final AnActionEvent e)
	{
		final Pattern pattern = Pattern.compile("([a-z_A-Z]|\\\\[iI])[a-z_A-Z0-9]*(\\.([a-z_A-Z]|\\\\[iI])[a-z_A-Z0-9]*)*");
		final Project project = e.getProject();

		if(project == null)
		{
			return;
		}

		String moduleName = Messages.showInputDialog(project, "Enter module name", "Add Ceylon Module", null, null, new InputValidatorEx()
		{
			@Override
			public boolean checkInput(String name)
			{
				return pattern.matcher(name).matches() && !"default".equals(name) && ModuleIndex.getInstance().get(name, project,
						GlobalSearchScope.projectScope(project)).isEmpty();
			}

			@Override
			public boolean canClose(String inputString)
			{
				return checkInput(inputString);
			}

			@Nullable
			@Override
			public String getErrorText(String name)
			{
				if(!pattern.matcher(name).matches())
				{
					return "Invalid module name";
				}
				else if("default".equals(name))
				{
					return "\"default\" is a reserved module";
				}
				else if(!ModuleIndex.getInstance().get(name, project, GlobalSearchScope.projectScope(project)).isEmpty())
				{
					return "Module already exists";
				}
				return null;
			}
		});

		VirtualFile eventSourceFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);

		if(moduleName == null || eventSourceFile == null)
		{
			return;
		}

		Module module = ModuleUtil.findModuleForFile(eventSourceFile, project);
		if(module == null)
		{
			return;
		}

		VirtualFile[] contentFolderFiles = ModuleRootManager.getInstance(module).getContentFolderFiles(ContentFolderScopes.of
				(ProductionContentFolderTypeProvider.getInstance()));
		if(contentFolderFiles.length == 0)
		{
			return;
		}

		PsiManager psiManager = PsiManager.getInstance(project);
		PsiDirectory directory = psiManager.findDirectory(contentFolderFiles[0]);

		if(directory == null)
		{
			return;
		}

		FileTemplateManager templateManager = FileTemplateManager.getInstance();
		PsiDirectory subdirectory = DirectoryUtil.createSubdirectories(moduleName, directory, ".");
		Properties variables = new Properties();
		variables.put("MODULE_NAME", moduleName);

		try
		{
			FileTemplateUtil.createFromTemplate(templateManager.getTemplate("module.ceylon"), "module.ceylon", variables, subdirectory);
			FileTemplateUtil.createFromTemplate(templateManager.getTemplate("package.ceylon"), "package.ceylon", variables, subdirectory);
			FileTemplateUtil.createFromTemplate(templateManager.getTemplate("run.ceylon"), "run.ceylon", variables, subdirectory);
		}
		catch(Exception e1)
		{
			LOGGER.error("Can't create file from template", e1);
		}
	}
}
