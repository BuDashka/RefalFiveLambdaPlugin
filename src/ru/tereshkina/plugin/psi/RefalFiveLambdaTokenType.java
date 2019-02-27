package ru.tereshkina.plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import ru.tereshkina.plugin.*;
import org.jetbrains.annotations.*;

public class RefalFiveLambdaTokenType extends IElementType {
    public RefalFiveLambdaTokenType(@NotNull @NonNls String debugName) {
        super(debugName, RefalFiveLambdaLanguage.INSTANCE);
    }

    public static TokenSet getCommentSet() {
        return TokenSet.create(RefalFiveLambdaTypes.LINE_COMMENT, RefalFiveLambdaTypes.MULTILINE_COMMENT
               /*, RefalFiveLambdaTypes.END_OF_LINE_COMMENT*/);
    }

    @Override
    public String toString() {
        return "RefalFiveLambdaTokenType." + super.toString();
    }
}