package com.dna.cactusoverwatch.utils;

/**
 * Created by Alex on 14.05.2016.
 */
public class Tender {

    private String tenderId="";
    private String title="";
    private String description="";
    private String status="";
    private String startingPrice="";
    private String endPrice="";
    private String dateOpened="";
    private String dateClosed="";
    private String executor="";

    public Tender(String tenderId, String title,
                  String description, String status,
                  String startingPrice, String endPrice,
                  String dateOpened, String dateClosed,
                  String executor) {
        this.tenderId = tenderId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.startingPrice = startingPrice;
        this.endPrice = endPrice;
        this.dateOpened = dateOpened;
        this.dateClosed = dateClosed;
        this.executor = executor;
    }

    public String getTenderId() {
        return tenderId;
    }

    public void setTenderId(String tenderId) {
        this.tenderId = tenderId;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(String startingPrice) {
        this.startingPrice = startingPrice;
    }

    public String getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(String endPrice) {
        this.endPrice = endPrice;
    }

    public String getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(String dateOpened) {
        this.dateOpened = dateOpened;
    }

    public String getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(String dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }
}
