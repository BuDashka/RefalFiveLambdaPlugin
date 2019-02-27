package ru.tereshkina.plugin;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.tereshkina.plugin.psi.RefalFiveLambdaTypes;

public class RefalFiveLambdaBraceMatcher implements PairedBraceMatcher {
    private static final BracePair[] PAIRS = new BracePair[] {
            new BracePair(RefalFiveLambdaTypes.LBRACE, RefalFiveLambdaTypes.RBRACE, true),
            new BracePair(RefalFiveLambdaTypes.LCHEVRON, RefalFiveLambdaTypes.RCHEVRON, true),
            new BracePair(RefalFiveLambdaTypes.LBRACKET, RefalFiveLambdaTypes.RBRACKET, true),
            new BracePair(RefalFiveLambdaTypes.LPAREN, RefalFiveLambdaTypes.RPAREN, true)

    };
    @Override
    public BracePair[] getPairs() {
        return PAIRS;
    }


    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType,
                                                   @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}