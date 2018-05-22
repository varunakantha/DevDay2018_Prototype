package com.example.vki.test2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    Button successButton;
    Button failButton;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        successButton = findViewById(R.id.btn_success);
        failButton = findViewById(R.id.btn_Fail);
        message = findViewById(R.id.tv_msg2);

        successButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message.setText("Great! We have done your reservation.\n See you there...!");
                message.setTextColor(Color.GREEN);
            }
        });

        failButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message.setText("Ooops ! Something has gone wrong. We will contact you soon");
                message.setTextColor(Color.RED);
            }
        });
    }
}
