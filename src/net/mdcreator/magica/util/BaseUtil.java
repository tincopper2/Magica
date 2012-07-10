package net.mdcreator.magica.util;

import java.io.*;
import java.net.URL;

public class BaseUtil {

    public static void copyFile(File from, File to) throws Exception{
        InputStream in = new FileInputStream(from);
        OutputStream out = new FileOutputStream(to);
        byte[] buf = new byte[1024];
        int len;
        while((len = in.read(buf)) > 0){
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

    public static void extractFile(String from, File to) throws Exception{
        InputStream in = BaseUtil.class.getResourceAsStream(from);
        OutputStream out = new FileOutputStream(to);
        byte[] buf = new byte[1024];
        int len;
        while((len = in.read(buf)) > 0){
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

    public static String getHTML(String url) throws Exception{
        URL html = new URL(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(html.openStream()));
        String inputLine;
        String output = "";
        while((inputLine = in.readLine()) != null){
            output = output + inputLine;
        }
        in.close();
        return output;
    }
}
