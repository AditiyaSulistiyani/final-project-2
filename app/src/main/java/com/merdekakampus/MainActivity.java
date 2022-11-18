package com.merdekakampus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private TextView txtAdminLogin,txtAbout,txtRegister,txtStaffLogin;
    private Button btnLoginHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtAdminLogin =  findViewById(R.id.txtAdminLogin);
        txtAbout =  findViewById(R.id.txtAbout);
        btnLoginHere =  findViewById(R.id.btnLoginHere);
        txtRegister =  findViewById(R.id.txtRegister);
        txtStaffLogin = findViewById(R.id.txtStaffLogin);
        txtStaffLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(MainActivity.this,
                        Staff_login.class);
                startActivity(intent);
            }
        });
        txtAdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(MainActivity.this,
                        Admin_login.class);
                startActivity(intent);
            }
        });
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(MainActivity.this,
                        User_register.class);
                startActivity(intent);
            }
        });


        btnLoginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(MainActivity.this,
                        User_Login.class);
                startActivity(intent);
            }
        });
        txtAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(MainActivity.this,
                        About_activity.class);
                startActivity(intent);
            }
        });

    }
}