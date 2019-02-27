package ru.tereshkina.plugin;


import com.intellij.lexer.FlexAdapter;
import java.io.Reader;

class RefalFiveLambdaLexerAdapter extends FlexAdapter {
    RefalFiveLambdaLexerAdapter() {
        super(new RefalFiveLambdaLexer(null));
    }
}
