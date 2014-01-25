package org.intellij.plugins.ceylon.annotator;

import org.intellij.plugins.ceylon.psi.CeylonAnnotationName;
import org.intellij.plugins.ceylon.psi.CeylonCompilerAnnotation;
import org.intellij.plugins.ceylon.psi.CeylonTypeName;
import org.intellij.plugins.ceylon.psi.CeylonTypeParameter;
import org.intellij.plugins.ceylon.psi.CeylonTypeParameters;
import org.intellij.plugins.ceylon.psi.CeylonTypedDeclaration;
import org.intellij.plugins.ceylon.psi.CeylonTypes;
import org.intellij.plugins.ceylon.psi.CeylonVisitor;
import org.jetbrains.annotations.NotNull;
import com.intellij.ide.highlighter.JavaHighlightingColors;
import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;

public class CeylonAnnotator extends CeylonVisitor implements Annotator {
    private AnnotationHolder annotationHolder;

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        this.annotationHolder = holder;

        element.accept(this);

        if (element instanceof PsiFile) {
            new CeylonTypeCheckerVisitor(annotationHolder).accept((PsiFile) element);
        }

        this.annotationHolder = null;
    }

    @Override
    public void visitAnnotationName(@NotNull CeylonAnnotationName o) {
        super.visitAnnotationName(o);

        Annotation anno = annotationHolder.createInfoAnnotation(o, null);
        anno.setTextAttributes(JavaHighlightingColors.ANNOTATION_NAME);
    }

    @Override
    public void visitCompilerAnnotation(@NotNull CeylonCompilerAnnotation o) {
        super.visitCompilerAnnotation(o);

        @SuppressWarnings("ConstantConditions")
        Annotation anno = annotationHolder.createInfoAnnotation(o.getNode().findChildByType(CeylonTypes.OP_ANNOTATION), null);
        anno.setTextAttributes(JavaHighlightingColors.ANNOTATION_NAME);
    }

    @Override
    public void visitTypeName(@NotNull CeylonTypeName name) {
        super.visitTypeName(name);

        if (PsiTreeUtil.getParentOfType(name, CeylonTypeParameter.class) != null) {
            Annotation anno = annotationHolder.createInfoAnnotation(name, null);
            anno.setTextAttributes(JavaHighlightingColors.TYPE_PARAMETER_NAME);
        } else {
            if (getTypeParameterInParentDeclaration(name) != null) {
                Annotation anno = annotationHolder.createInfoAnnotation(name, null);
                anno.setTextAttributes(JavaHighlightingColors.TYPE_PARAMETER_NAME);
            }
        }
    }

    private CeylonTypeName getTypeParameterInParentDeclaration(CeylonTypeName typeName) {
        CeylonTypedDeclaration decl;
        PsiElement element = typeName;

        while ((decl = PsiTreeUtil.getParentOfType(element, CeylonTypedDeclaration.class)) != null) {
            CeylonTypeParameters typeParameters = decl.getTypeParameters();
            if (typeParameters != null) {
                for (CeylonTypeParameter typeParameter : typeParameters.getTypeParameterList()) {
                    CeylonTypeName typeNameDeclaration = typeParameter.getTypeName();
                    if (typeName.getText().equals(typeNameDeclaration.getText())) {
                        return typeNameDeclaration;
                    }
                }
            }

            element = decl;
        }

        return null;
    }
}
