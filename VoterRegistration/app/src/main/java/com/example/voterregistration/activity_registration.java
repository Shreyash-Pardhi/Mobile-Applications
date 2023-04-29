package com.example.voterregistration;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class activity_registration extends AppCompatActivity {
    boolean invalid = false;
    String Colector="";
    TextView txtalertName;
    EditText UserName,UserPassword,UserContact,UserAddhar,UserComment;
    Button SubmitSave;
    RadioButton Malebtn,Femalbtn;
    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        UserName=findViewById(R.id.userName);
        UserPassword=findViewById(R.id.userPassword);
        UserContact=findViewById(R.id.userContact);
        UserAddhar=findViewById(R.id.userAddhar);
        UserComment=findViewById(R.id.usercomment);
        txtalertName=findViewById(R.id.userAlert);
        Malebtn =findViewById(R.id.Male);
        Femalbtn=findViewById(R.id.Female);
        SubmitSave=findViewById(R.id.btnSubmit);
        SubmitSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String name = UserName.getText().toString();
                String Pascode=UserPassword.getText().toString();
                String contact=UserContact.getText().toString();
                String Addhar=UserAddhar.getText().toString();
                String comment=UserComment.getText().toString();
                if (name.isEmpty()){
                    Toast.makeText(activity_registration.this,"Pleas fill the password field",Toast.LENGTH_SHORT).show();
                }
                else if (name.equals("Sameh") ||name.equals("UlHaq")){
                    invalid=true;
                    txtalertName.setText("Name Already exist");
                }
                else if(Pascode.isEmpty()){
                    Toast.makeText(activity_registration.this,"Pleas fill the password field",Toast.LENGTH_SHORT).show();
                }
                else if (contact.isEmpty()){
                    Toast.makeText(activity_registration.this,"Pleas fill the Contact field",Toast.LENGTH_SHORT).show();
                }
                else if (contact.isEmpty()){
                    Toast.makeText(activity_registration.this,"Pleas fill the Addhar NO. field",Toast.LENGTH_SHORT).show();
                }
                else if (comment.isEmpty()){
                    Toast.makeText(activity_registration.this,"Pleas fill the Comment field",Toast.LENGTH_SHORT).show();
                }
            }
        });
        SubmitSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Registration successful", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), activity_vote.class);
                startActivity(i);
            }
        });
    }}
