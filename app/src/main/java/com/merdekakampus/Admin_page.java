package com.merdekakampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_page extends AppCompatActivity {

    private Button btnAddStaff,btnAddStock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        btnAddStaff = findViewById(R.id.btnAddStaff);
        btnAddStock = findViewById(R.id.btnAddStock);

        btnAddStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent
                        = new Intent(Admin_page.this,
                        Admin_regis_staf.class);
                startActivity(intent);

            }
        });

        btnAddStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(Admin_page.this,
                        Admin_input.class);
                startActivity(intent);
            }
        });
    }
}