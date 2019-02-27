package ru.tereshkina.plugin.psi;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.extapi.psi.PsiFileBase;
import org.jetbrains.annotations.*;
import ru.tereshkina.plugin.RefalFiveLambdaFileType;
import ru.tereshkina.plugin.RefalFiveLambdaLanguage;

import javax.swing.*;

public class RefalFiveLambdaFile extends PsiFileBase {
    public RefalFiveLambdaFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, RefalFiveLambdaLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return RefalFiveLambdaFileType.INSTANCE;
    }


    @Override
    public String toString() {
        return "Refal Five Lambda File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}