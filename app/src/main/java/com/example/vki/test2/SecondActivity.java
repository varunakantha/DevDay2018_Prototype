package com.example.vki.test2;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button takePicThenSendButton;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ProgressBar getAndSendImageProgBar;
    TextView sendDataLable;
    CheckBox companyPaidForMeCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        this.getSupportActionBar().setTitle("DEV DAY-2018");
        takePicThenSendButton = findViewById(R.id.btn_takePicAndSend);
        getAndSendImageProgBar = findViewById(R.id.sendImage_progressBar);
        sendDataLable = findViewById(R.id.tv_sendData);
        companyPaidForMeCheckBox = findViewById(R.id.cb_companyPaid);
        getAndSendImageProgBar.setVisibility(View.INVISIBLE);
        sendDataLable.setVisibility(View.INVISIBLE);

        takePicThenSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!companyPaidForMeCheckBox.isChecked()){
                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                    }
                }else{
                   sendImageData();
                }
            }
        });

        companyPaidForMeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    takePicThenSendButton.setText("Send This Info");
                }else{
                    takePicThenSendButton.setText("Take a Pic and Send");
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            sendImageData();
        }
    }

    private void sendImageData () {
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

    @Override
    public void onBackPressed() {

    }
}
