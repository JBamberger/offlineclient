package de.jbamberger.api

import android.util.Log
import java.io.*

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

internal object ExecuteAsRoot {

    fun execute(commands: List<String>): Boolean {
        var retval = false

        try {
            if (commands.isNotEmpty()) {
                val suProcess = Runtime.getRuntime().exec("su")
                val os = DataOutputStream(suProcess.outputStream)

                // Execute commands that require root access
                for (currCommand in commands) {
                    os.writeBytes("$currCommand\n")
                    os.flush()
                }

                os.writeBytes("exit\n")
                os.flush()

                try {
                    val suProcessRetval = suProcess.waitFor()
                    // Root access granted or denied
                    retval = 255 != suProcessRetval
                } catch (ex: Exception) {
                    Log.e("ROOT", "Error executing root action", ex)
                }
            }
        } catch (ex: IOException) {
            Log.w("ROOT", "Can't get root access", ex)
        } catch (ex: SecurityException) {
            Log.w("ROOT", "Can't get root access", ex)
        } catch (ex: Exception) {
            Log.w("ROOT", "Error executing internal operation", ex)
        }

        return retval
    }

    fun canRunRootCommands(): Boolean {
        try {
            val suProcess = Runtime.getRuntime().exec("su")
            val os = DataOutputStream(suProcess.outputStream)
            val osRes = BufferedReader(InputStreamReader(DataInputStream(suProcess.inputStream)))

            // Getting the id of the current user to check if this is root
            os.writeBytes("id\n")
            os.flush()

            val retval: Boolean
            val currUid = osRes.readLine()
            when {
                currUid == null -> {
                    Log.d("ROOT", "Can't get root access or denied by user")
                    return false
                }
                currUid.contains("uid=0") -> {
                    retval = true
                    Log.d("ROOT", "Root access granted")
                }
                else -> {
                    retval = false
                    Log.d("ROOT", "Root access rejected: $currUid")
                }
            }

            os.writeBytes("exit\n")
            os.flush()
            return retval
        } catch (e: Exception) {
            // Can't get root !
            // Probably broken pipe exception on trying to write to output stream (os) after su failed, meaning that the device is not rooted

            Log.d("ROOT", "Root access rejected [${e.javaClass.name}] : ${e.message}")
            return false
        }
    }

}