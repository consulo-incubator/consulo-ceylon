// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.ceylon.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.plugins.ceylon.psi.CeylonTypes.*;
import org.intellij.plugins.ceylon.psi.*;

public class CeylonAliasDeclarationImpl extends CeylonCompositeElementImpl implements CeylonAliasDeclaration {

  public CeylonAliasDeclarationImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public CeylonTypeConstraints getTypeConstraints() {
    return findChildByClass(CeylonTypeConstraints.class);
  }

  @Override
  @NotNull
  public CeylonTypeName getTypeName() {
    return findNotNullChildByClass(CeylonTypeName.class);
  }

  @Override
  @Nullable
  public CeylonTypeParameters getTypeParameters() {
    return findChildByClass(CeylonTypeParameters.class);
  }

  @Override
  @Nullable
  public CeylonTypeSpecifier getTypeSpecifier() {
    return findChildByClass(CeylonTypeSpecifier.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CeylonVisitor) ((CeylonVisitor)visitor).visitAliasDeclaration(this);
    else super.accept(visitor);
  }

}
