package com.dna.cactusoverwatch.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by piekie on 5/14/2016.
 */

public class Constants {
    public static final int SHOWN_STANDARD = 20;
    public static final int SHOWN_PEEK = 100;
    public static final String APP_PREFS = "overwatch_preferences";
    public static final String PROZORRO_ALL = "https://lb.api-sandbox.openprocurement.org/api/2.3/tenders";

    public static int VOTE = 1;
    public static int USERS_AVERAGE = 100;

    public static String format(String s) {
        String f = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

        DateFormat ff = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ", Locale.ENGLISH);
        Date date = new Date();
        try {
            date = ff.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat ff_target = new SimpleDateFormat("dd-MM HH:mm", Locale.ENGLISH);
        return ff_target.format(date);
    }

}
