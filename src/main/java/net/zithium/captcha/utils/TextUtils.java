package net.zithium.captcha.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class TextUtils {

    /**
     * @param message to be formatted.
     * @return formatted message
     */
    public static Component color(String message) {
        return MiniMessage.miniMessage().deserialize(message);
    }

}
