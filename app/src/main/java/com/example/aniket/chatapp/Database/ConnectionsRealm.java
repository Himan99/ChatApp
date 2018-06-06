package com.example.aniket.chatapp.Database;

import io.realm.RealmObject;

public class ConnectionsRealm extends RealmObject {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
