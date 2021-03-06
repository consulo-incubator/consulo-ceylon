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

public class CeylonInferredAttributeDeclarationImpl extends CeylonCompositeElementImpl implements CeylonInferredAttributeDeclaration {

  public CeylonInferredAttributeDeclarationImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public CeylonBlock getBlock() {
    return findChildByClass(CeylonBlock.class);
  }

  @Override
  @Nullable
  public CeylonInitializer getInitializer() {
    return findChildByClass(CeylonInitializer.class);
  }

  @Override
  @NotNull
  public CeylonMemberName getMemberName() {
    return findNotNullChildByClass(CeylonMemberName.class);
  }

  @Override
  @Nullable
  public CeylonSpecifier getSpecifier() {
    return findChildByClass(CeylonSpecifier.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CeylonVisitor) ((CeylonVisitor)visitor).visitInferredAttributeDeclaration(this);
    else super.accept(visitor);
  }

}
