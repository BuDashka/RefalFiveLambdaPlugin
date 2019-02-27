package ru.tereshkina.plugin;

import com.intellij.lang.Language;

public class RefalFiveLambdaLanguage extends Language {
    public static final Language INSTANCE = new RefalFiveLambdaLanguage();

    private RefalFiveLambdaLanguage() {
        super("Refal Five Lambda");
    }

}