package uz.nits.maydontop.helper;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HandlerUrl {
    public String removeParamsUrl;
    public String request;
    private Exception exception;
    private URL url;

    public StringBuilder httpServiceCall(String requestUrl) {
        request = requestUrl;
        StringBuilder stringBuilder = new StringBuilder();

        HttpURLConnection httpURLConnection = null;
        try {
            url = new URL(request);
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (url != null && httpURLConnection != null)
        try {
            InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
        } catch (Exception e) {
            this.exception = e;

            return null;
        } finally {
            httpURLConnection.disconnect();
        }

        return stringBuilder;
    }
}
