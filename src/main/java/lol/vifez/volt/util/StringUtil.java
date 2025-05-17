package lol.vifez.volt.util;

public class StringUtil {
    public static String color(String message) {
        return message.replace("&", "\u00a7");
    }
}