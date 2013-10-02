package org.consulo.ceylon.module.extension;

import org.consulo.module.extension.impl.ModuleExtensionWithSdkImpl;
import org.intellij.plugins.ceylon.sdk.CeylonSdkType;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.projectRoots.SdkType;

/**
 * @author VISTALL
 * @since 02.10.13.
 */
public class CeylonModuleExtension extends ModuleExtensionWithSdkImpl<CeylonModuleExtension>
{
	public CeylonModuleExtension(@NotNull String id, @NotNull Module module)
	{
		super(id, module);
	}

	@Override
	protected Class<? extends SdkType> getSdkTypeClass()
	{
		return CeylonSdkType.class;
	}
}
