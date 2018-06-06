package com.example.aniket.chatapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

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

import static android.widget.Toast.LENGTH_SHORT;

public class SignInActivity extends AppCompatActivity {


    private static final int RC_SIGN_IN = 1;
    private static final String TAG ="signIn" ;
    private static final String TAG2 ="async" ;
    GoogleSignInClient mGoogleSignInClient;

    public  static String UserEmailId,userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(  R.layout.activity_sign_in);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);
        findViewById(  R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }
    private void updateUI(GoogleSignInAccount account) {
        if(account==null)
        {
            findViewById(  R.id.sign_in_button).setVisibility(View.VISIBLE);
        }
        else
        {
            Toast.makeText(this,"Auth Successfull", LENGTH_SHORT).show();
            findViewById(  R.id.sign_in_button).setVisibility(View.INVISIBLE);
            UserEmailId= account.getEmail();
            userName=account.getDisplayName();
            Log.d(TAG,account.getDisplayName());
            Log.d(TAG,account.getFamilyName());
            Log.d(TAG,account.getGivenName());

            checkRegistration();

        }
    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    static private class  NetAsyncTask extends AsyncTask<String,Integer,Integer>{

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
            Integer foundUser = 0;
            String url="http://192.168.43.171:3000/find-user";
            JSONObject info   = new JSONObject();
            try {
                info.put("email",strings[0]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            foundUser = connectToServer(url,info);
            return foundUser;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("TAG",integer.toString());
            if(integer==0) {
                Toast.makeText(context,"User Does not Exists",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, CreateUserActivity.class);
                intent.putExtra("email", UserEmailId);
                intent.putExtra("name", userName);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
            else
            {
                Intent intent = new Intent(context, ChatListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Log.d("TAG","going to chat list");
                context.startActivity(intent);
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
                    result=Integer.parseInt(jsonObject.getString("result"));
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

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount account =task.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
//            String idToken = account.getIdToken();
//            Log.d(TAG,idToken);
            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
        }
    }

    private void checkRegistration()
    {
        NetAsyncTask netAsyncTask=new NetAsyncTask(this);
        netAsyncTask.execute(UserEmailId);
//        netAsyncTask.cancel(true);
    }

}
