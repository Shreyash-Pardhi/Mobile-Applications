package com.example.voterregistration;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class activity_vote extends AppCompatActivity {

    private int scoreFirst;
    private int scoreSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);
        // initializing textview
        TextView txtFirst = (TextView) findViewById(R.id.txtFirst);
        TextView txtSecond = (TextView) findViewById(R.id.txtSecond);

        // initializing button view
        Button btnFirst = (Button) findViewById(R.id.btnFirst);
        Button btnSecond = (Button) findViewById(R.id.btnSecond);

        // setting initial value to text view
        txtFirst.setText(String.valueOf(0));
        txtSecond.setText(String.valueOf(0));

        // updating textview on button click
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreFirst++;
                txtFirst.setText(String.valueOf(scoreFirst));
            }
        });

        // updating textview on button click
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreSecond++;
                txtSecond.setText(String.valueOf(scoreSecond));
            }
        });
    }
}
