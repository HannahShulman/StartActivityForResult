package com.example.first.startactivityforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    final int PROFILE_INFO_REQUEST_CODE = 5489;
    TextView nameTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTv = findViewById(R.id.nameTv);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivityForResult(intent, PROFILE_INFO_REQUEST_CODE);
            }
        }, 5000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PROFILE_INFO_REQUEST_CODE && resultCode == RESULT_OK){
            if(data != null){
                String profileString = data.getStringExtra("profile");
                Gson gson = new Gson();
                Profile profile = gson.fromJson(profileString, Profile.class);
                DataManager.setMyProfile(profile);
                nameTv.setText("Hello   "+profile.name+"  "+profile.lastName);
                if (DataManager.getMyProfile() != null){
                    Intent intent = new Intent(MainActivity.this, FinalActivity.class);
                    startActivity(intent);
                }

            }
        }
    }
}
