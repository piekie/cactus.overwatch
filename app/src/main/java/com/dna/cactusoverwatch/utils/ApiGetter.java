package com.dna.cactusoverwatch.utils;

import android.content.Context;
import android.util.Log;

import com.dna.cactusoverwatch.cashe.TendersCache;
import com.dna.cactusoverwatch.prozorroUtils.ProgressTask;
import com.firebase.client.Firebase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class ApiGetter {

    public ApiGetter() {
        Log.i("API", "api_getter initialized");
    }

    public void getTenders(Context context) {
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

        Random rand = new Random();

        int shown = context.getSharedPreferences(Constants.APP_PREFS, Context.MODE_PRIVATE).getInt("shown", Constants.SHOWN_STANDARD);
        int[] random = new int[shown];

        Set<Integer> set_r = new HashSet<>(shown);

        for (int i = 0; i < shown; i++) {
            int r = rand.nextInt(Constants.SHOWN_PEEK);
            while (set_r.contains(r)) {
                r = rand.nextInt(Constants.SHOWN_PEEK);
            }
            random[i] = r;
            set_r.add(r);
        }

        String[] ids = new String[shown + 1];
        ids[0] = String.valueOf(shown);
        String[] ids_access = new String[shown];

        try {
            JSONObject parsed = new JSONObject(result);
            JSONArray data = parsed.getJSONArray("data");

            for (int i = 1; i <= shown; i++) {
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

            Firebase.setAndroidContext(context);
            Firebase _tenders = new Firebase(Hierarchy.DB_TENDERS);

            for (int i = 0; i < shown; i++) {
                JSONObject obj = got.getJSONObject(i).getJSONObject("data");

                String description = obj.getJSONArray("items").getJSONObject(0).getJSONObject("classification").getString("description");
                String amount = obj.getJSONObject("value").getString("amount");
                String title = obj.getJSONObject("procuringEntity").getString("name");
                String status = obj.getString("status");
                String start_date = obj.getJSONObject("complaintPeriod").getString("startDate");
                String end_date = obj.getJSONObject("enquiryPeriod").getString("endDate");
                String end_price = amount; //TODO:
                String executor = "";

                Tender t = new Tender(ids_access[i], description, title, "open", amount, end_price, start_date, end_date, executor);

                if (_tenders.child(ids_access[i]) != null) {
                    TenderCutted tc = new TenderCutted(ids_access[i], start_date, String.valueOf(278 / (1 + 277 / Constants.USERS_AVERAGE)), status, "0");
                    _tenders.child(ids_access[i]).setValue(tc);
                }

                TendersCache.tenders.add(t);
            }

        } catch (JSONException e){
            e.printStackTrace();
        }
    }
}
