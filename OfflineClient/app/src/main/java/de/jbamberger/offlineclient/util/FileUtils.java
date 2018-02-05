package de.jbamberger.offlineclient.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

public class FileUtils {

    public static String readFile(String path) throws IOException {
        return readFile(new File(path), "utf-8");
    }

    public static String readFile(File file, String encoding) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append("\n");
        }
        reader.close();
        return builder.toString();
    }
}
