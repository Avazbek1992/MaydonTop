package uz.nits.maydontop.helper;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class DataStorage {
    Context context;
    private String KEY_ID = "KEY_ID";

    public DataStorage() {
    }

    public DataStorage(Context context) {
        this.context = context;
    }

    public String getKEY_ID() {
        return KEY_ID;
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("country.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public ArrayList<String> getCountry() {

        String couuntryJson = loadJSONFromAsset();
        ArrayList<String> countryArray = new ArrayList<>();
        countryArray.add("<<---Viloyatni tanlash--->>");
        try {
            JSONArray jsonArray = new JSONArray(couuntryJson);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String country = jsonObject.getString("G1");
                if (!countryArray.contains(country)) {
                    countryArray.add(country);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return countryArray;
    }

    public ArrayList<String> getDistrict(int index) {
        String districtJson = loadJSONFromAsset();
        ArrayList<String> countrys = getCountry();
        ArrayList<String> districtArray = new ArrayList<>();
        districtArray.add("<<---Tumanni tanlash--->>");
        try {
            JSONArray jsonArray = new JSONArray(districtJson);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String district = jsonObject.getString("G2");
                String country = jsonObject.getString("G1");
                if (!districtArray.contains(district) && countrys.get(index).contains(country)) {
                    districtArray.add(district);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return districtArray;
    }
}
