package ru.tereshkina.plugin;

import com.intellij.openapi.fileTypes.*;
import org.jetbrains.annotations.NotNull;


public class RefalFiveLambdaFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(RefalFiveLambdaFileType.INSTANCE);
        fileTypeConsumer.consume(RefalFiveLambdaIncludeFileType.INSTANCE);
    }
}
