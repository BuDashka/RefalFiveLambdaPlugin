package ru.tereshkina.plugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


import javax.swing.*;

public class RefalFiveLambdaFileType extends LanguageFileType {
    public static final RefalFiveLambdaFileType INSTANCE = new RefalFiveLambdaFileType();

    private RefalFiveLambdaFileType() {
        super(RefalFiveLambdaLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Refal Five Lambda";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Refal-5\u03BB";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "ref";
    }

    @Override
    public boolean isReadOnly() { return false; }

    @Nullable
    @Override
    public Icon getIcon() {
        return RefalFiveLambdaIcons.FILE;
    }

}
