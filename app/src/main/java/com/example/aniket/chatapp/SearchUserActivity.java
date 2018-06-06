package com.example.aniket.chatapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import io.realm.Realm;
import io.realm.RealmResults;
import com.example.aniket.chatapp.Database.UserIdRealm;
public class SearchUserActivity extends AppCompatActivity {

    Button mSearchButton;
    Realm realm=Realm.getDefaultInstance();
    static String uid;
    static Button mStartChatButton;
    static String chatId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
        Intent i=getIntent();
        final EditText mToSearch=findViewById(R.id.toSearch);
        mSearchButton=findViewById(R.id.search_button);
        mStartChatButton=findViewById(R.id.start_chat);
        RealmResults<UserIdRealm> uid_realm=realm.where(UserIdRealm.class).findAll();
        for(UserIdRealm uidrealm: uid_realm)
            uid=uidrealm.getUid();
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mToSearch.getText().equals(null)){
                    Toast.makeText(getApplicationContext(),"Please give an email id",Toast.LENGTH_SHORT).show();
                }
                else{
                    NetAsyncTask netAsyncTask=new NetAsyncTask(getApplicationContext());
                    Editable email=mToSearch.getText();
                    Log.d("TAG",email.toString());
                    netAsyncTask.execute(email.toString());
                }
            }
        });
    }


    static private class  NetAsyncTask extends AsyncTask<String,Integer,Integer> {

        Context context;
        String foundUser = "{\"result\":\"0\"}";
        JSONObject object,userObject;
        private NetAsyncTask(Context context) {
            this.context = context.getApplicationContext();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected Integer doInBackground(String... strings) {
            String url;
            JSONObject info   = new JSONObject();
            try {
                info.put("email",strings[0]);
                Log.d("TAG",info.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            // foundUser = connectToServer(url,info);
            foundUser=connectToServer(info);
            try {
                JSONObject fuser=new JSONObject(foundUser);
                if(fuser.getString("result").equals("0"))
                    return 0;
                else
                    return 1;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return 0;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("TAG",integer.toString());
            if(integer==0) {
                Toast.makeText(context,"nope",Toast.LENGTH_SHORT).show();
                mStartChatButton.setVisibility(View.GONE);
            }
            else {
                mStartChatButton.setVisibility(View.VISIBLE);
                mStartChatButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            userObject=object.getJSONObject("user");
                            Log.d("user",userObject.toString());
                            String id=userObject.getString("_id");
                            JSONObject user_ids=new JSONObject();
                            user_ids.put("u2",id);
                            user_ids.put("u1",uid);
                           // createChat(user_ids);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Intent intent = new Intent(context, ChatActivity.class);
                        intent.putExtra("chat_id",chatId);
                        Log.d("chat_id",chatId);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                });
                //    Toast.makeText(context,"noooooope",Toast.LENGTH_SHORT).show();
            }
        }
        private void createChat(JSONObject users){
            URL obj = null;
            try {
                obj = new URL("http://192.168.225.34:3000/create-chat");
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                Log.d("users", users.toString());
                con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                con.setRequestProperty("Accept", "application/json");
                OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
                wr.write(users.toString());
                wr.flush();

                Integer responseCode = con.getResponseCode();
                Log.d("GET Response Code :: ", responseCode.toString());
                if (responseCode == HttpURLConnection.HTTP_OK) { // success
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                            con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        chatId = inputLine;
                        Log.d("chatid",chatId);
                    }
                    in.close();
                }
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private String connectToServer(JSONObject info)
        {
            String result = null;
            try {
                URL obj = new URL("http://192.168.43.171:3000/find-user");
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                Log.d("info",info.toString());
                con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                con.setRequestProperty("Accept", "application/json");
                OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
                Log.d("TAG","here");
                wr.write(info.toString());
                wr.flush();

                Integer responseCode = con.getResponseCode();
                Log.d("GET Response Code :: " , responseCode.toString());
                if (responseCode == HttpURLConnection.HTTP_OK) { // success
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                            con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        Log.d("TAG",inputLine);
                        object=new JSONObject(inputLine);
                        //userObject=object.getJSONObject("user");
//                        Log.d("TAG",userObject.toString());
                        response.append(inputLine);
                    }
                    Log.i("TAG", response.toString());
                    result=response.toString();
                    in.close();
                }
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return result;
        }
    }
}

