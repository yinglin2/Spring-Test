package com.spring.javai18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceI18n {
    public static void main(String[] args) {
        ResourceBundle resourceBundleEn = ResourceBundle.getBundle("messages",
                new Locale("en","GB"));
        System.out.println(resourceBundleEn.getString("test"));

        ResourceBundle resourceBundleZh = ResourceBundle.getBundle("messages",
                new Locale("zh","CN"));
        System.out.println(resourceBundleZh.getString("test"));
    }
}
