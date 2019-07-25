package ru.tereshkina.plugin;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import ru.tereshkina.plugin.psi.RefalFiveLambdaTypes;

import java.util.HashSet;
import java.util.Set;

import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class RefalFiveLambdaSyntaxHighlighter extends SyntaxHighlighterBase {
    static final TextAttributesKey RFL_KEYWORD =
            createTextAttributesKey("REFAL_FIVE_LAMBDA_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    static final TextAttributesKey RFL_NAME =
            createTextAttributesKey("REFAL_FIVE_LAMBDA_NAME", DefaultLanguageHighlighterColors.IDENTIFIER);
    static final TextAttributesKey RFL_SEMICOLON =
            createTextAttributesKey("REFAL_FIVE_LAMBDA_SEMICOLON", SEMICOLON);
    static final TextAttributesKey RFL_FUNC_PTR =
            createTextAttributesKey("REFAL_FIVE_LAMBDA_FUNC_PTR", FUNCTION_DECLARATION);
    static final TextAttributesKey RFL_COMMENT =
            createTextAttributesKey("REFAL_FIVE_LAMBDA_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    static final TextAttributesKey RFL_NUMBER =
            createTextAttributesKey("REFAL_FIVE_LAMBDA_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    static final TextAttributesKey RFL_STRING =
            createTextAttributesKey("REFAL_FIVE_LAMBDA_STRING", DefaultLanguageHighlighterColors.STRING);
    static final TextAttributesKey RFL_CHARS =
            createTextAttributesKey("REFAL_FIVE_LAMBDA_CHARS", DefaultLanguageHighlighterColors.STRING);
    static final TextAttributesKey RFL_VARIABLE =
            createTextAttributesKey("REFAL_FIVE_LAMBDA_VARIABLE", DefaultLanguageHighlighterColors.INSTANCE_FIELD);

    private static Set<IElementType> KEYWORD_ELEMENTS = new HashSet<>();
    static {
        KEYWORD_ELEMENTS.add(RefalFiveLambdaTypes.EXTERN);
        KEYWORD_ELEMENTS.add(RefalFiveLambdaTypes.ENUM);
        KEYWORD_ELEMENTS.add(RefalFiveLambdaTypes.EENUM);
        KEYWORD_ELEMENTS.add(RefalFiveLambdaTypes.SWAP);
        KEYWORD_ELEMENTS.add(RefalFiveLambdaTypes.ESWAP);
        KEYWORD_ELEMENTS.add(RefalFiveLambdaTypes.ENTRY);
        KEYWORD_ELEMENTS.add(RefalFiveLambdaTypes.FORWARD);
        KEYWORD_ELEMENTS.add(RefalFiveLambdaTypes.INCLUDE);
        KEYWORD_ELEMENTS.add(RefalFiveLambdaTypes.EXTRN);
        KEYWORD_ELEMENTS.add(RefalFiveLambdaTypes.EXTERNALL);
        KEYWORD_ELEMENTS.add(RefalFiveLambdaTypes.INLINE);
        KEYWORD_ELEMENTS.add(RefalFiveLambdaTypes.DRIVE);
        KEYWORD_ELEMENTS.add(RefalFiveLambdaTypes.SPEC);
    }

    private static Set<IElementType> COMMENT_ELEMENTS = new HashSet<>();
    static {
        COMMENT_ELEMENTS.add(RefalFiveLambdaTypes.MULTILINE_COMMENT);
        //COMMENT_ELEMENTS.add(RefalFiveLambdaTypes.END_OF_LINE_COMMENT);
        COMMENT_ELEMENTS.add(RefalFiveLambdaTypes.LINE_COMMENT);
       // COMMENT_ELEMENTS.add(RefalFiveLambdaTypes.CPP_INLINE);

    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new RefalFiveLambdaLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType type) {
        if (COMMENT_ELEMENTS.contains(type)) {
            return pack(RFL_COMMENT);
        }
        if (type.equals(RefalFiveLambdaTypes.NAME)) {
            return pack(RFL_NAME);
        }
        if (type.equals(RefalFiveLambdaTypes.QUOTEDSTRING)) {
            return pack(RFL_STRING);
        }
        if (type.equals(RefalFiveLambdaTypes.COMPOUND)) {
            return pack(RFL_CHARS);
        }
        if (type.equals(RefalFiveLambdaTypes.INTEGER_LITERAL)) {
            return pack(RFL_NUMBER);
        }
        if (type.equals(RefalFiveLambdaTypes.VARIABLE)) {
            return pack(RFL_VARIABLE);
        }
        if (type.equals(RefalFiveLambdaTypes.SEMICOLON)) {
            return pack(RFL_SEMICOLON);
        }
        if (type.equals(RefalFiveLambdaTypes.COMMA)) {
            return pack(RFL_SEMICOLON);
        }
        if (KEYWORD_ELEMENTS.contains(type)) {
            return pack(RFL_KEYWORD);
        }
        return new TextAttributesKey[0];

    }
}
