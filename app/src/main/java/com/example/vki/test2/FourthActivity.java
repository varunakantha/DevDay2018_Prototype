package com.example.vki.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class FourthActivity extends AppCompatActivity {

    ImageView sessionInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        this.getSupportActionBar().setTitle("DEV DAY-2018");
        sessionInfo = findViewById(R.id.imgv_sessioninfo);
        //sessionInfo.setImageResource(R.mipmap.payments); //<- change images dynamically

        sessionInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FourthActivity.this, "Elaaa", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //Do nothing
    }
}
