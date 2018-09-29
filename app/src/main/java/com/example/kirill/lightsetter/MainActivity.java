package com.example.kirill.lightsetter;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout constraintLayout;
    private int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.layout);
        Button btnRed = (Button) findViewById(R.id.btnRed);
        Button btnYellow = (Button) findViewById(R.id.btnYellow);
        Button btnGreen = (Button) findViewById(R.id.btnGreen);

        btnRed.setOnClickListener(this);
        btnYellow.setOnClickListener(this);
        btnGreen.setOnClickListener(this);

    }




    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnRed:
                color = getResources().getColor(R.color.red);
                constraintLayout.setBackgroundColor(color);
                break;
            case R.id.btnYellow:
                color = getResources().getColor(R.color.yellow);
                constraintLayout.setBackgroundColor(color);
                break;
            case R.id.btnGreen:
                color = getResources().getColor(R.color.green);
                constraintLayout.setBackgroundColor(color);
        }

    }


    @Override
    public void onResume(){
        super.onResume();
        resetUI();
    }

    private void resetUI() {
        findViewById(R.id.layout).setBackgroundColor(color);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        color =savedInstanceState.getInt("color");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("color",color);
    }
}

