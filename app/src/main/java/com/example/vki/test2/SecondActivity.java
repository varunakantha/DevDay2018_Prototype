package com.example.vki.test2;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button takePicThenSendButton;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ProgressBar getAndSendImageProgBar;
    TextView sendDataLable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        this.getSupportActionBar().setTitle("DEV DAY-2018");
        takePicThenSendButton = findViewById(R.id.btn_takePicAndSend);
        getAndSendImageProgBar = findViewById(R.id.sendImage_progressBar);
        sendDataLable = findViewById(R.id.tv_sendData);
        getAndSendImageProgBar.setVisibility(View.INVISIBLE);
        sendDataLable.setVisibility(View.INVISIBLE);

        takePicThenSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            getAndSendImageProgBar.setVisibility(View.VISIBLE);
            sendDataLable.setVisibility(View.VISIBLE);
            sendDataLable.setText("Sending...");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        Intent goToThirdActivity = new Intent(getApplicationContext(),ThirdActivity.class);
                        startActivity(goToThirdActivity);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


        }
    }

}
