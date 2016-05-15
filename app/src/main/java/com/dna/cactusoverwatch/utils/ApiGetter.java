package com.dna.cactusoverwatch.utils;

import android.util.Log;

import com.dna.cactusoverwatch.cashe.TendersCache;
import com.dna.cactusoverwatch.prozorroUtils.ProgressTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;
import java.util.concurrent.ExecutionException;

public class ApiGetter {

    public ApiGetter() {
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
        int[] random = new int[10];
        for (int i = 0; i < random.length; i++) {
            random[i] = r.nextInt(100);
        }

        String[] ids = new String[11];
        String[] ids_access = new String[10];
        ids[0] = "10";

        try {
            JSONObject parsed = new JSONObject(result);
            JSONArray data = parsed.getJSONArray("data");

            for (int i = 1; i < random.length + 1; i++) {
                ids[i] = Constants.PROZORRO_ALL + "/" + data.getJSONObject(random[i - 1]).getString("id");
                ids_access[i - 1] = data.getJSONObject(random[i - 1]).getString("id");
            }
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
            JSONArray got = new JSONArray(result);

            for (int i = 0; i < 5; i++) {
                JSONObject obj = got.getJSONObject(i);

                String description = "";
                String amount = obj.getJSONObject("value").getString("amount");
                String title = obj.getJSONObject("procuringEntity").getString("name");
                String status = obj.getString("status");
                String start_date = obj.getJSONObject("complaintPeriod").getString("startDate");
                String end_date = obj.getJSONObject("enquiryPeriod").getString("endDate");
                String end_price = amount; //TODO:
                String executor = "";

              //  if (status.equals("closed")) {
//                    executor;
//                    end_price = ""
//                    end_date = obj.
                //}

                Tender t = new Tender(ids_access[i], description, title, status, amount, end_price, start_date, end_date, executor);
                TendersCache.tenders.add(t);

            }

        } catch (JSONException e){
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
