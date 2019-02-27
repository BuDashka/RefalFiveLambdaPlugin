package ru.tereshkina.plugin;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.*;
import org.jetbrains.annotations.*;
import ru.tereshkina.plugin.psi.RefalFiveLambdaUtils;

import javax.swing.*;
import java.util.Map;

public class RefalFiveLambdaColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Keyword", RefalFiveLambdaSyntaxHighlighter.RFL_KEYWORD),
            new AttributesDescriptor("Name", RefalFiveLambdaSyntaxHighlighter.RFL_NAME),
            new AttributesDescriptor("Function Declaration", RefalFiveLambdaSyntaxHighlighter.RFL_FUNC_PTR),
            new AttributesDescriptor("Variable", RefalFiveLambdaSyntaxHighlighter.RFL_VARIABLE),
            new AttributesDescriptor("Semicolon and Comma", RefalFiveLambdaSyntaxHighlighter.RFL_SEMICOLON),
            new AttributesDescriptor("Comments and C++ inline code", RefalFiveLambdaSyntaxHighlighter.RFL_COMMENT),
            new AttributesDescriptor("Number", RefalFiveLambdaSyntaxHighlighter.RFL_NUMBER),
            new AttributesDescriptor("String", RefalFiveLambdaSyntaxHighlighter.RFL_STRING)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return RefalFiveLambdaIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new RefalFiveLambdaSyntaxHighlighter();
    }


    @NotNull
    @Override
    public String getDemoText() {
        return RefalFiveLambdaUtils.SAMPLE;
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Refal Five Lambda";
    }
}