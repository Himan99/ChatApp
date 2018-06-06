package com.example.aniket.chatapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class CreateUserActivity extends AppCompatActivity {

//    SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    static int RC_gallery=10;
    EditText mUserEmailId,mUserName;
    ImageView profileImage;
    Button mRegisterButton;
    String userEmailId,userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        mUserEmailId=findViewById( R.id.create_user_emailid);
        mUserName=findViewById( R.id.create_user_name);
        profileImage=findViewById( R.id.create_user_image);
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent,RC_gallery);
            }
        });
        Bundle extras=getIntent().getExtras();
        userEmailId=extras.getString("email");
        userName=extras.getString("name");
        mUserEmailId.setText(userEmailId);
        mUserName.setText(userName);
        mRegisterButton=findViewById(R.id.create_user_register);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetAsyncTask netAsyncTask=new NetAsyncTask(getApplicationContext());
                netAsyncTask.execute(userEmailId,userName);
            }
        });
    }

    private class  NetAsyncTask extends AsyncTask<String,Integer,Integer> {

        Context context;

        private NetAsyncTask(Context context) {
            this.context = context.getApplicationContext();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected Integer doInBackground(String... strings) {
            String url="http://192.168.43.171:3000/create-user";
            JSONObject info   = new JSONObject();
            try {
                info.put("email",strings[0]);
                info.put("name",strings[1]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
             connectToServer(url,info);
            return 1;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("TAG",integer.toString());
            if(integer==1) {
                Toast.makeText(context,"User Created",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ChatListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
            else
            {
                Toast.makeText(context,"User Not Created",Toast.LENGTH_SHORT).show();
            }
        }

        private Integer connectToServer(String url,JSONObject info)
        {
            Integer result = null;
            try {
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                Log.d("info",info.toString());
                con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                con.setRequestProperty("Accept", "application/json");
                OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
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
                        response.append(inputLine);
                    }
                    Log.i("TAG", response.toString());
                    JSONObject jsonObject=new JSONObject(response.toString());

                        if (jsonObject.get("name").equals( userName))
                            result = 1;
                        else
                            result=0;

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10 &&resultCode==RESULT_OK&&data!=null) {
            Uri selectedImage = data.getData();
            Log.d("URI",selectedImage.toString());
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString("ImageUri",selectedImage.toString());
//            editor.putString("email",userEmailId.getText().toString());
//            editor.putString("userName",userName.getText().toString());
//            editor.apply();
            try {
                Bitmap d = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                int nh = (int) (d.getHeight() * (512.0 / d.getWidth()));
                Bitmap scaled = Bitmap.createScaledBitmap(d, 512, nh, true);
                profileImage.setImageBitmap(scaled);
//            profileImage.setImageURI(selectedImage);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
