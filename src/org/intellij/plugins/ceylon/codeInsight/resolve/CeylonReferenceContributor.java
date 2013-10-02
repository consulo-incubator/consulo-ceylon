package org.intellij.plugins.ceylon.codeInsight.resolve;

import static com.intellij.patterns.PsiJavaPatterns.psiElement;
import static com.intellij.patterns.StandardPatterns.instanceOf;

import org.intellij.plugins.ceylon.psi.CeylonNamedDeclaration;
import org.intellij.plugins.ceylon.psi.CeylonTypes;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceContributor;
import com.intellij.psi.PsiReferenceRegistrar;

public class CeylonReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(PsiReferenceRegistrar registrar) {
        @SuppressWarnings("unchecked")
		PsiElementPattern.Capture<PsiElement> typeNames = psiElement(CeylonTypes.TYPE_NAME).withParent(
                instanceOf(CeylonNamedDeclaration.class)
        );

        registrar.registerReferenceProvider(typeNames, new CeylonTypeReferenceProvider());
    }
}
