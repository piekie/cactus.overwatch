package com.dna.cactusoverwatch.cashe;

import com.dna.cactusoverwatch.utils.Tender;

import java.util.ArrayList;

/**
 * Created by Alex on 15.05.2016.
 */
public class TendersCache {

    public static ArrayList<Tender> tenders = new ArrayList<Tender>();

    public static void loadTenders() {
        Tender tender = new Tender(" ВАТ \"Нечесне підприємство\"","Ручкі кулькаві","3000 грн","10.05.2016",
                "asdfsafasdf","sdfsfasf","sdfasdfsdf","as134134fewfaf","sdfwfwef");
        Tender tender1 = new Tender(" ВАТ \"Нечесне підприємство\"","Ручки кулькові","3000 грн","01.01.2016",
                "asdfsafasdf","sdfsfasf","sdfasdfsdf","as134134fewfaf","sdfwfwef");
        Tender tender2= new Tender("Національний технічний університет України \"Київський політехнічний інститут\"",
                "послуги з постачання продуктів харчування та напоїв з доставкою до місця розташування СГ СОТ «Глобус» НТУУ «КПІ»",
                "340 000 UAH без ПДВ","19.05.2016 10:00",
                "asdfsafasdf","sdfsfasf","sdfasdfsdf","as134134fewfaf","sdfwfwef");
        Tender tender3 = new Tender("ВАТ \"Нечесне підприємство\" ","Ручки кулькові","4000000 грн. ","20.05.2016",
                "asdfsafasdf","sdfsfasf","sdfasdfsdf","as134134fewfaf","sdfwfwef");
        Tender tender4 = new Tender("Afjsdjkfsdjfajlsdfa","ajsdfjsjfsaj","slkdflajsfjask","asdfj0njasdf",
                "asdfsafasdf","sdfsfasf","sdfasdfsdf","as134134fewfaf","sdfwfwef");
        Tender tender5 = new Tender("Afjsdjkfsdjfajlsdfa","ajsdfjsjfsaj","slkdflajsfjask","asdfjnjasdf",
                "asdfsafasdf","sdfsfasf","sdfasdfsdf","as134134fewfaf","sdfwfwef");
        tenders.add(tender);
        tenders.add(tender1);
        tenders.add(tender2);
        tenders.add(tender3);
        tenders.add(tender4);
        tenders.add(tender5);
    }
}
