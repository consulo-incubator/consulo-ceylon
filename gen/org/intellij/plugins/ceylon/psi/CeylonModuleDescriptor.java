// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.ceylon.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import org.intellij.plugins.ceylon.psi.stub.ModuleStub;
import com.intellij.psi.StubBasedPsiElement;

public interface CeylonModuleDescriptor extends CeylonCompositeElement, StubBasedPsiElement<ModuleStub> {

  @NotNull
  CeylonImportModuleList getImportModuleList();

  @NotNull
  CeylonModuleVersion getModuleVersion();

  @NotNull
  CeylonPackagePath getPackagePath();

}
