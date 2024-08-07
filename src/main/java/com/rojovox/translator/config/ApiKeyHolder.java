package com.rojovox.translator.config;

public class ApiKeyHolder {
    private static String apiKey;

    public static void setApiKey(String key) {
        apiKey = key;
    }

    public static String getApiKey() {
        return apiKey;
    }
}