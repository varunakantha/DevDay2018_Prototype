package com.example.vki.test2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner tshirtSizeSpinner;
    Spinner userTypeSpinner;
    Button registerButton;
    ProgressBar registrationProBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("DEV DAY - 2018");
        setSupportActionBar(toolbar);

        tshirtSizeSpinner = findViewById(R.id.spinner_tshirtsize);
        userTypeSpinner = findViewById(R.id.spinner_usertype);
        registrationProBar = findViewById(R.id.reg_progressBar);
        registrationProBar.setVisibility(View.INVISIBLE);

        List<String> tShirtSizes = new ArrayList<>();
        tShirtSizes.add("XS");
        tShirtSizes.add("S");
        tShirtSizes.add("M");
        tShirtSizes.add("L");
        tShirtSizes.add("XL");
        tShirtSizes.add("XXL");

        List<String> usertypes = new ArrayList<>();
        usertypes.add("Delegate");
        usertypes.add("Speaker");
        usertypes.add("Invitee");


        ArrayAdapter<String> tshirtSizeDataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tShirtSizes);
        tshirtSizeSpinner.setAdapter(tshirtSizeDataAdapter);

        ArrayAdapter<String>userTypeDataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, usertypes);
        userTypeSpinner.setAdapter(userTypeDataAdapter);


        registerButton = findViewById(R.id.btn_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrationProBar.setVisibility(View.VISIBLE);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                            Intent goToFourthdActivity = new Intent(getApplicationContext(),FourthActivity.class);
                            startActivity(goToFourthdActivity);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();


            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            return true;
        }

        if (id == R.id.action_login) {
            DialogMsgFragment recoveryDialog = new DialogMsgFragment();
            recoveryDialog.show(getSupportFragmentManager(),"RecoveryDialog");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

    }
}
