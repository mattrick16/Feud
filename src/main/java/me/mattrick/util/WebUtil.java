package me.mattrick.util;

import me.mattrick.Feud;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class WebUtil {

    public static String getStringFromClassPath(String path) throws IOException {
        return FileUtils.readFileToString(new File(Feud.class.getResource(path).getFile()), Charset.defaultCharset());
    }

}
