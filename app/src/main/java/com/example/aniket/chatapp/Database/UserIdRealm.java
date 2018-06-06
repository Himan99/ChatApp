package com.example.aniket.chatapp.Database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserIdRealm extends RealmObject {
    @PrimaryKey
    String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
