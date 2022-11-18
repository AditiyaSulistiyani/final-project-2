package com.merdekakampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Home_page extends AppCompatActivity {

    private LinearLayout cloth,electronic,book,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        cloth =  findViewById(R.id.cloth);
        electronic =  findViewById(R.id.electronic);
        book =  findViewById(R.id.book);
        other =  findViewById(R.id.other);

        cloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(Home_page.this,
                        FilterCategoryClothes.class);
                startActivity(intent);
            }
        });

        electronic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(Home_page.this,
                        FilterCategoryElectronic.class);
                startActivity(intent);
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(Home_page.this,
                        FilterCatagoryBooks.class);
                startActivity(intent);

            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(Home_page.this,
                        OtherCategoryFilter.class);
                startActivity(intent);
            }
        });


    }
}