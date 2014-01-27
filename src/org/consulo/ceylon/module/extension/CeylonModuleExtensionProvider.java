package org.consulo.ceylon.module.extension;

import javax.swing.Icon;

import org.consulo.module.extension.ModuleExtensionProvider;
import org.intellij.plugins.ceylon.CeylonIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.module.Module;

/**
 * @author VISTALL
 * @since 02.10.13.
 */
public class CeylonModuleExtensionProvider implements ModuleExtensionProvider<CeylonModuleExtension,CeylonMutableModuleExtension>
{
	@Nullable
	@Override
	public Icon getIcon()
	{
		return CeylonIcons.Ceylon;
	}

	@NotNull
	@Override
	public String getName()
	{
		return "Ceylon";
	}

	@NotNull
	@Override
	public CeylonModuleExtension createImmutable(@NotNull String s, @NotNull Module module)
	{
		return new CeylonModuleExtension(s, module);
	}

	@NotNull
	@Override
	public CeylonMutableModuleExtension createMutable(@NotNull String s, @NotNull Module module)
	{
		return new CeylonMutableModuleExtension(s, module);
	}
}
