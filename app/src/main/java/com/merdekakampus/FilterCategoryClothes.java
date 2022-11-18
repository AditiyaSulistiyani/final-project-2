package com.merdekakampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class FilterCategoryClothes extends AppCompatActivity {
private LinearLayout menclothes,womenclothes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_category_clothes);
        menclothes =  findViewById(R.id.menclothes);
        womenclothes = findViewById(R.id.womenclothes);

        menclothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(FilterCategoryClothes.this,
                        CategoryClothesMan.class);
                startActivity(intent);

            }
        });
        womenclothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(FilterCategoryClothes.this,
                        CategoryClothesWoman.class);
                startActivity(intent);

            }
        });
    }
}