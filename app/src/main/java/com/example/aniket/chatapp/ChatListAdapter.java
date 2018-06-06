package com.example.aniket.chatapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aniket.chatapp.Database.ConnectionsRealm;
//import com.example.dhruvatara.letschat.Database.ConnectionsRealm;

import io.realm.Realm;
import io.realm.RealmResults;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ChatViewHolder> {
    Realm realm;
    RealmResults<ConnectionsRealm> connectionsRealms;
    Context context;

    public ChatListAdapter(Context context, RealmResults<ConnectionsRealm> connectionsRealms) {
        super();
        this.context=context;
        this.connectionsRealms=connectionsRealms;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_card,parent,false);
        return new ChatViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        ConnectionsRealm cr=connectionsRealms.get(position);
        holder.mEmail.setText(cr.getEmail());
       // holder.mEmail.setText("test");
    }

    @Override
    public int getItemCount() {
        return connectionsRealms.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        TextView mEmail;
        public ChatViewHolder(View itemView) {
            super(itemView);
            mEmail=itemView.findViewById(R.id.user_id);
        }
    }
}
