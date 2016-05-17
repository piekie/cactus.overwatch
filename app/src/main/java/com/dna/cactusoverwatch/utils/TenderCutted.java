package com.dna.cactusoverwatch.utils;

/**
 * Created by piekie on 5/15/2016.
 */
public class TenderCutted {

    private String tenderId;
    private String date;
    private String score;
    private String status;
    private String watchers;

    public TenderCutted() {
    }

    public TenderCutted(String tenderId, String date, String score, String status, String watchers) {

        this.tenderId = tenderId;
        this.date = date;
        this.score = score;
        this.status = status;
        this.watchers = watchers;
    }

    public String getTenderId() {

        return tenderId;
    }

    public void setTenderId(String tenderId) {
        this.tenderId = tenderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getWatchers() {
        return watchers;
    }

    public void setWatchers(String watchers) {
        this.watchers = watchers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
