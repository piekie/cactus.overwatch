package com.dna.cactusoverwatch.utils;

/**
 * Created by Alex on 14.05.2016.
 */
public class Tender {

    private String title;
    private String description;
    private String tenderId;
    private String procuringEntity;
    private String value;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAuctionPeriod() {
        return auctionPeriod;
    }

    public void setAuctionPeriod(String auctionPeriod) {
        this.auctionPeriod = auctionPeriod;
    }

    public Tender(String title, String description, String auctionPeriod, String value) {

        this.title = title;
        this.description = description;
        this.auctionPeriod = auctionPeriod;
        this.value = value;
    }

    private String auctionPeriod;

}
