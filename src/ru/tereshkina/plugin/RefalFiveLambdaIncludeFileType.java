package ru.tereshkina.plugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class RefalFiveLambdaIncludeFileType extends LanguageFileType {
    public static final RefalFiveLambdaIncludeFileType INSTANCE =
            new RefalFiveLambdaIncludeFileType();

    private RefalFiveLambdaIncludeFileType() {
        super(RefalFiveLambdaLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Refal Five Lambda Include File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Refal-5\u03BB include file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "refi";
    }

    @Override
    public boolean isReadOnly() { return false; }

    @Nullable
    @Override
    public Icon getIcon() {
        return RefalFiveLambdaIcons.FILE;
    }

}
