package com.ceiba.citas_medicas.domain.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class Message {

    private static final String LANGUAGE = "es";
    private static final String COUNTRY = "CO";
    private static final ResourceBundle BUNDLE;

    static {
        var locale = new Locale(LANGUAGE, COUNTRY);
        BUNDLE = ResourceBundle.getBundle("messages", locale);
    }

    private Message() { }

    public static String getMessage(String key) {
        return BUNDLE.getString(key);
    }
}
