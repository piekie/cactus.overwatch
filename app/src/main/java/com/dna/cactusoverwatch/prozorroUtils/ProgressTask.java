package com.dna.cactusoverwatch.prozorroUtils;

import android.os.AsyncTask;

import com.shaded.fasterxml.jackson.databind.util.JSONPObject;

import org.json.JSONArray;
import org.json.JSONObject;
import org.shaded.apache.http.util.ByteArrayBuffer;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ProgressTask extends AsyncTask<String, Void, String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(String... arg0) {
        String result;
        String temp = "";

        JSONArray jA = new JSONArray();

        try{
            for (int i = 0; i < Integer.parseInt(arg0[0]); i++) {
                URL myURL = new URL(arg0[i + 1]);

                URLConnection ucon = myURL.openConnection();

                InputStream is = ucon.getInputStream();

                BufferedInputStream bis = new BufferedInputStream(is);

                ByteArrayBuffer baf = new ByteArrayBuffer(50);

                int current = 0;
                while ((current = bis.read()) != -1) {
                    baf.append((byte) current);
                }

                temp = new String(baf.toByteArray());
                JSONObject j = new JSONObject(temp);
                jA.put(j);
            }

            if (Integer.parseInt(arg0[0]) == 1) {
                result = temp;
            } else {
                result = jA.toString();
            }
        }catch(Exception e){
            result = e.getMessage();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String content) {

    }
}
