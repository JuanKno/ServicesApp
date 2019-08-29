package com.example.coc.common;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {

    private static final String APP_SETTINGS_FILE = "APP_SETTINGS";

    private SharedPreferencesManager() {
    }

    private static SharedPreferences geSharedPreferences() {

        return MyApp.geContext().getSharedPreferences(APP_SETTINGS_FILE, Context.MODE_PRIVATE);

    }

    public static void setSomeStringValue(String dataLabel, String dataValue) {
        SharedPreferences.Editor editor = geSharedPreferences().edit();
        editor.putString(dataLabel, dataValue);
        editor.commit();

    }

    public static String getSomeStringValue(String dataLabel) {
        return geSharedPreferences().getString(dataLabel, null);
    }
}
