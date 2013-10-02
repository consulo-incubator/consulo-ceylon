package org.intellij.plugins.ceylon.parser;

import org.intellij.plugins.ceylon.CeylonLanguage;
import org.intellij.plugins.ceylon.psi.CeylonFile;
import org.intellij.plugins.ceylon.psi.CeylonTypes;
import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.lang.LanguageVersion;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.IStubFileElementType;
import com.intellij.psi.tree.TokenSet;

public class CeylonParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IStubFileElementType(CeylonLanguage.INSTANCE) {
        @Override
        public int getStubVersion() {
            return 0;
        }
    };

    @NotNull
    @Override
    public Lexer createLexer(Project project, LanguageVersion languageVersion) {
        return new CeylonLexer();
    }

    @Override
    public PsiParser createParser(Project project, LanguageVersion languageVersion) {
        return new CeylonParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens(LanguageVersion languageVersion) {
        return TokenSet.create(TokenType.WHITE_SPACE);
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens(LanguageVersion languageVersion) {
        return TokenSet.create(CeylonTypes.LINE_COMMENT, CeylonTypes.MULTI_LINE_COMMENT);
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements(LanguageVersion languageVersion) {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return CeylonTypes.Factory.createElement(node);
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new CeylonFile(viewProvider);
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY; // TODO
    }
}
