package org.intellij.plugins.ceylon;

import org.jetbrains.annotations.NotNull;
import com.intellij.ide.highlighter.JarArchiveFileType;
import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;

public class CeylonFileTypeFactory extends FileTypeFactory {

    @Override
    public void createFileTypes(@NotNull FileTypeConsumer consumer) {
        consumer.consume(CeylonFileType.INSTANCE, CeylonFileType.DEFAULT_EXTENSION);
        consumer.consume(JarArchiveFileType.INSTANCE, "src;car");
    }
}
