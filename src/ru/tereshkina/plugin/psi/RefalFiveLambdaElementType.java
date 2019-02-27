package ru.tereshkina.plugin.psi;

import com.intellij.psi.tree.IElementType;
import ru.tereshkina.plugin.RefalFiveLambdaLanguage;
import org.jetbrains.annotations.*;

public class RefalFiveLambdaElementType extends IElementType {
    public RefalFiveLambdaElementType(@NotNull @NonNls String debugName) {
        super(debugName, RefalFiveLambdaLanguage.INSTANCE);
    }
}
