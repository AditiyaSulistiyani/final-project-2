package com.merdekakampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class CategoryClothesWoman extends AppCompatActivity {
    private LinearLayout tshirtmen,formalsmen,jeansmen,shoesmen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_clothes_woman);

        tshirtmen =  findViewById(R.id.tshirtmen);
        formalsmen = findViewById(R.id.formalsmen);
        jeansmen = findViewById(R.id.jeansmen);
        shoesmen = findViewById(R.id.shoesmen);

        tshirtmen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(CategoryClothesWoman.this,
                        Tshirtproductswoman.class);
                startActivity(intent);
            }
        });
        formalsmen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(CategoryClothesWoman.this,
                        Formalwomensproducts.class);
                startActivity(intent);
            }
        });
        jeansmen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(CategoryClothesWoman.this,
                        Jeanswomanproduct.class);
                startActivity(intent);
            }
        });
        shoesmen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(CategoryClothesWoman.this,
                        Shoesproductswoman.class);
                startActivity(intent);
            }
        });
    }

}