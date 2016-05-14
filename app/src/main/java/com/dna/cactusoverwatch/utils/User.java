package com.dna.cactusoverwatch.utils;

/**
 * Created by piekie on 5/14/2016.
 */
public class User {
    private String email;
    private String password;

    private long score;
    private long watched_list;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
