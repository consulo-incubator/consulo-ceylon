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

public class CeylonCaseTypeImpl extends CeylonCompositeElementImpl implements CeylonCaseType {

  public CeylonCaseTypeImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public CeylonMemberName getMemberName() {
    return findChildByClass(CeylonMemberName.class);
  }

  @Override
  @Nullable
  public CeylonQualifiedType getQualifiedType() {
    return findChildByClass(CeylonQualifiedType.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CeylonVisitor) ((CeylonVisitor)visitor).visitCaseType(this);
    else super.accept(visitor);
  }

}
