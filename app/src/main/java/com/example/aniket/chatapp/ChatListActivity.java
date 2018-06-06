package com.example.aniket.chatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.aniket.chatapp.Database.ConnectionsRealm;
//import com.example.dhruvatara.letschat.Database.ConnectionsRealm;

import io.realm.Realm;
import io.realm.RealmResults;

public class ChatListActivity extends AppCompatActivity {
    Realm realm;
    RealmResults<ConnectionsRealm> connectionsRealms;
    RecyclerView recyclerView;
    ChatListAdapter chatListAdapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm=Realm.getDefaultInstance();
        prepare();
        fab=findViewById(R.id.fab);

        connectionsRealms=realm.where(ConnectionsRealm.class).findAll();
        for(ConnectionsRealm c: connectionsRealms)
            Log.d("itemz",c.getEmail());
        Log.d("itemz","here");
        setContentView(R.layout.activity_chat_list);
        recyclerView=findViewById(R.id.rvChats);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        chatListAdapter=new ChatListAdapter(this,connectionsRealms);
        recyclerView.setAdapter(chatListAdapter);
        chatListAdapter.notifyDataSetChanged();

    }
    public void prepare(){
        Realm realm=Realm.getDefaultInstance();
        for(int i=0;i<5;i++){
            realm.beginTransaction();
            ConnectionsRealm cr=realm.createObject(ConnectionsRealm.class);
            cr.setEmail("dt"+i+"@gmail.com");
            Log.d("going inside",cr.getEmail());
            realm.commitTransaction();
        }
    }
    public void searchUser(View view) {
        Intent i=new Intent(ChatListActivity.this,SearchUserActivity.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
