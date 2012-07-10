package net.mdcreator.magica.util;

import java.util.Arrays;

public class FetchUtil {

    public static String getDownloadLink(String url) throws Exception{
        String file = BaseUtil.getHTML(url);
        String hrefStr = file.substring(file.indexOf("user-action-download\"><span><a href=\"") + "user-action-download\"><span><a href=\"".length());
        hrefStr = hrefStr.substring(0, hrefStr.indexOf("\""));
        return hrefStr;
    }

    public static String[] getChangeLog(String url) throws Exception{
        String file = BaseUtil.getHTML(url);
        String changelogStr = file.substring(file.indexOf("Change log</h3><ul>") + "Change log</h3><ul>".length());
        changelogStr = changelogStr.substring(0, changelogStr.indexOf("</ul>"));
        String[] changelog = changelogStr.split("<li>");
        for(int i=0; i<changelog.length; i++){
            changelog[i] = changelog[i].replace("</li>", "");
        }
        return Arrays.copyOfRange(changelog, 1, changelog.length);
    }

    public static String[] getCaveats(String url) throws Exception{
        String file = BaseUtil.getHTML(url);
        String caveatsStr = file.substring(file.indexOf("Known caveats</h3><ul>") + "Known caveats</h3><ul>".length());
        caveatsStr = caveatsStr.substring(0, caveatsStr.indexOf("</ul>"));
        String[] caveats = caveatsStr.split("<li>");
        for(int i=0; i<caveats.length; i++){
            caveats[i] = caveats[i].replace("</li>", "");
        }
        return Arrays.copyOfRange(caveats, 1, caveats.length);
    }
}
