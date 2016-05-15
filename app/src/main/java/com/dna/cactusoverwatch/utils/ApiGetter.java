package com.dna.cactusoverwatch.utils;

import android.util.Log;

import com.dna.cactusoverwatch.prozorroUtils.ProgressTask;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;
import java.util.concurrent.ExecutionException;

public class ApiGetter {

    private GsonBuilder gsonBuilder;

    public ApiGetter() {
        gsonBuilder = new GsonBuilder();
        Log.i("API", "api_getter initialized");
    }

    public void getTenders(long page) {
        ProgressTask pt = new ProgressTask();
        pt.execute("1", Constants.PROZORRO_ALL);

        String result = "";
        try {
            result = pt.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Random r = new Random();
        int[] random = new int[20];
        for (int i = 0; i < random.length; i++) {
            random[i] = r.nextInt(100);
        }

        String[] ids = new String[21];
        ids[0] = "20";

        try {
            JSONObject parsed = new JSONObject(result);
            JSONArray data = parsed.getJSONArray("data");

            for (int i = 1; i < random.length + 1; i++) {
                ids[i] = Constants.PROZORRO_ALL + "/" + data.getJSONObject(random[i - 1]).getString("id");
            }

            Log.d("B", ids[2]);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ProgressTask pt1 = new ProgressTask();
        pt1.execute(ids);
        try {
            result = pt1.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            JSONArray parsed = new JSONArray(result);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        //return tenders;
    }

    public String decode(String target) {
        String str = target.split(" ")[0];
        str = str.replace("\\","");
        String[] arr = str.split("u");
        String text = "";
        for(int i = 1; i < arr.length; i++){
            int hexVal = Integer.parseInt(arr[i], 16);
            text += (char)hexVal;
        }
        return text;
    }
}
