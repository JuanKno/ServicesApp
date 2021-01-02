package com.example.coc.ui;

import android.content.Intent;
import android.os.Bundle;

import com.example.coc.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    FloatingActionButton fab;
    int pressBackTwo = 0;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_my_services:

                    return true;
                case R.id.navigation_profile:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        fab = findViewById(R.id.fab);

        getSupportActionBar().hide();

        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentContainer, new ServicioFragment())
                .commit();


    }


    public void RegisterNewService(View view) {

        Intent intent = new Intent(this, NewServiceActivity.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        if (pressBackTwo == 0) {
            Toast.makeText(getApplicationContext(), "Presione una vez más para salir de la aplicación.", Toast.LENGTH_SHORT).show();
            pressBackTwo++;
        } else {
            super.onBackPressed();
        }
        new CountDownTimer(3000, 1000) {

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                pressBackTwo = 0;

            }
        }.start();
    }
}
