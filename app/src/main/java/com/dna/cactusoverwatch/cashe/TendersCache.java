package com.dna.cactusoverwatch.cashe;

import com.dna.cactusoverwatch.utils.ApiGetter;
import com.dna.cactusoverwatch.utils.Tender;

import java.util.ArrayList;

/**
 * Created by Alex on 15.05.2016.
 */
public class TendersCache {

    public static ArrayList<Tender> tenders = new ArrayList<Tender>();

    public static void loadTenders() {
        ApiGetter ap = new ApiGetter();
        ap.getTenders(0);
    }
}
