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

public class CeylonIndexImpl extends CeylonCompositeElementImpl implements CeylonIndex {

  public CeylonIndexImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public CeylonAdditiveExpression getAdditiveExpression() {
    return findNotNullChildByClass(CeylonAdditiveExpression.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CeylonVisitor) ((CeylonVisitor)visitor).visitIndex(this);
    else super.accept(visitor);
  }

}
