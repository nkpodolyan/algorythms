package com.positive;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    /**
     * @param args
     * @throws Exception
     */
    @Contract
    public static void main(@Nullable String[] args) throws Exception {
        URL url = new URL("https://docs.google.com/spreadsheets/d/103RumPs9iaDOuv8mV0J5C8E2zugA87lhH48EoAPK3Xo/export#xls");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        System.out.println(connection.getResponseCode());
    }


}
