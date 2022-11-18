package com.merdekakampus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Staff_login extends AppCompatActivity {
    private EditText staffLogin,staffPassword;
    private Button btnLoginStaff;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);
        mAuth =  FirebaseAuth.getInstance();
        staffLogin = findViewById(R.id.staffLogin);
        staffPassword = findViewById(R.id.staffPassword);
        btnLoginStaff = findViewById(R.id.btnLoginStaff);

        btnLoginStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAuth.signInWithEmailAndPassword(staffLogin.getText().toString(), staffPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(
                                    getApplicationContext(),
                                    "LOGIN STAFF BERHASIL",
                                    Toast.LENGTH_LONG)
                                    .show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(),
                                    "Gagal Login", Toast.LENGTH_LONG).show();

                        }
                    }
                });

                /*mAuth.createUserWithEmailAndPassword(adminLogin.getText().toString(), adminPassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),
                                            "Registration successful!",
                                            Toast.LENGTH_LONG)
                                            .show();
                                }
                                else {

                                    // Registration failed
                                    Toast.makeText(
                                            getApplicationContext(),
                                            "Registration failed!!"
                                                    + " Please try again later",
                                            Toast.LENGTH_LONG)
                                            .show();
                                }
                            }
                        });*/
            }
        });

    }
}