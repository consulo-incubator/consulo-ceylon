// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.ceylon.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CeylonDeclarationOrStatement extends CeylonCompositeElement {

  @Nullable
  CeylonAssertion getAssertion();

  @NotNull
  CeylonCompilerAnnotations getCompilerAnnotations();

  @Nullable
  CeylonDeclaration getDeclaration();

  @Nullable
  CeylonStatement getStatement();

}
