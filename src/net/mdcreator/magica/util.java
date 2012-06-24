package net.mdcreator.magica;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class util {

    public static void copyFile(String from, File to){
        try {
            InputStream in = util.class.getResourceAsStream(from);
            OutputStream out = new FileOutputStream(to);
            byte[] buf = new byte[1024];
            int len;
            while((len = in.read(buf)) > 0){
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
