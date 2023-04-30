package com.app.examapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private EditText Name, Password;
    private String nAME, pASS;
    //Button Login;
    private String URL = "https://justforfunforfun.000webhostapp.com/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nAME = pASS = "";
        Name = findViewById(R.id.uid);
        Password = findViewById(R.id.pass);
       // Login = (Button)findViewById(R.id.button);
    }

    public void login(View view)
    {
        //nAME = Name.getText().toString().trim();
        ///pASS = Password.getText().toString().trim();
        if(Name.getText().toString().equals("shreyash") && Password.getText().toString().equals("1234") || Name.getText().toString().equals("prathmesh") && Password.getText().toString().equals("5678"))
        {
          Intent in = new Intent(LoginActivity.this, ExamActivity.class);
          startActivity(in);
        }
        else{
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }

}