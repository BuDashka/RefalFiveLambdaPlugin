package ru.tereshkina.plugin;

import com.intellij.lang.Commenter;

public class RefalFiveLambdaCommenter implements Commenter {
    public String getLineCommentPrefix() {
        return "*";
    }

    public String getBlockCommentPrefix() {
        return "/*";
    }

    public String getBlockCommentSuffix() {
        return "*/";
    }

    public String getCommentedBlockCommentPrefix() {
        return "/*";
    }

    public String getCommentedBlockCommentSuffix() {
        return "*/";
    }
}
