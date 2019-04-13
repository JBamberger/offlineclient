package de.jbamberger.api

import java.io.*

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

internal object FileUtils {

    @Throws(IOException::class)
    fun readFile(path: String): String {
        return readFile(File(path), "utf-8")
    }

    @Throws(IOException::class)
    fun readFile(file: File, encoding: String): String {
        val reader = BufferedReader(InputStreamReader(FileInputStream(file), encoding))
        var line = reader.readLine()
        val builder = StringBuilder()
        while (line != null) {
            builder.append(line)
            builder.append("\n")
            line = reader.readLine()
        }
        reader.close()
        return builder.toString()
    }
}
