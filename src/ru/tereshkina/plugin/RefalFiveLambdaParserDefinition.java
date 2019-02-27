package ru.tereshkina.plugin;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import ru.tereshkina.plugin.parser.RefalFiveLambdaParser;
import ru.tereshkina.plugin.psi.RefalFiveLambdaFile;
import ru.tereshkina.plugin.psi.RefalFiveLambdaTokenType;
import ru.tereshkina.plugin.psi.RefalFiveLambdaTypes;

public class RefalFiveLambdaParserDefinition implements ParserDefinition {
    private static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);

    private static final IFileElementType FILE =
            new IFileElementType(Language.findInstance(RefalFiveLambdaLanguage.class));

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new RefalFiveLambdaLexerAdapter();
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return RefalFiveLambdaTokenType.getCommentSet();
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new RefalFiveLambdaParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new RefalFiveLambdaFile(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return RefalFiveLambdaTypes.Factory.createElement(node);
    }
}
