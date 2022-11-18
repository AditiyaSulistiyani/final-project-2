package com.merdekakampus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Admin_regis_staf extends AppCompatActivity {
    private EditText usernameStaff,pwStaff,pwConfirmStaff;
    private Button registerStaff;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_regis_staf);

        usernameStaff = findViewById(R.id.usernameStaff);
        pwStaff = findViewById(R.id.pwStaff);
        pwConfirmStaff = findViewById(R.id.pwConfirmStaff);
        registerStaff = findViewById(R.id.registerStaff);
        mAuth =  FirebaseAuth.getInstance();

        registerStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username, pw, confpw;

                username = usernameStaff.getText().toString();
                pw = pwStaff.getText().toString();
                confpw = pwConfirmStaff.getText().toString();

                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter email!!",
                            Toast.LENGTH_LONG)
                            .show();
                    return;
                }

                if (TextUtils.isEmpty(pw)) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter password!!",
                            Toast.LENGTH_LONG)
                            .show();
                    return;
                }

                if (TextUtils.isEmpty(confpw)) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter confirm password!!",
                            Toast.LENGTH_LONG)
                            .show();
                    return;
                }

                if (! pw.equals(confpw)) {
                    Toast.makeText(getApplicationContext(),
                            "password & confirm password tidak sesuai!!",
                            Toast.LENGTH_LONG)
                            .show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(username, pw)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),
                                            "Registration"+ username +" successful!",
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
                        });



            }
        });

    }
}