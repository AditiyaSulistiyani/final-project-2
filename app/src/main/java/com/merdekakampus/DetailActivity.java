package com.merdekakampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
private ImageView detailimg;
private TextView namabarang,kuantitasbarang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailimg = findViewById(R.id.detailimg);
        namabarang = findViewById(R.id.namabarang);
        kuantitasbarang = findViewById(R.id.kuantitasbarang);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String namabrg = extras.getString("namabrg");
        String kuantitasbrg = extras.getString("kuantitasbrg");

        namabarang.setText(namabrg);
        kuantitasbarang.setText(kuantitasbrg);
        setimage(namabrg);

    }

    private void setimage(String namabrg) {
        if(namabrg.equals("T-shirt(A)")){
            detailimg.setImageResource(R.drawable.tshirtman);

        } else if(namabrg.equals("T-shirt(B)")){
            detailimg.setImageResource(R.drawable.tshirtmentwo);
        }else if(namabrg.equals("T-shirt(C)")){
            detailimg.setImageResource(R.drawable.tshirtman);
        }else if(namabrg.equals("T-shirt(D)")){
            detailimg.setImageResource(R.drawable.tshirtmentwo);
        }else if(namabrg.equals("shoes(C)")){
            detailimg.setImageResource(R.drawable.shoeswomen);
        }else if(namabrg.equals("shoes(D)")){
            detailimg.setImageResource(R.drawable.shoeswomentwo);
        }else if(namabrg.equals("shoes(A)")){
            detailimg.setImageResource(R.drawable.shoesmentwo);
        }else if(namabrg.equals("shoes(B)")){
            detailimg.setImageResource(R.drawable.shoesmenthree);
        }else if(namabrg.equals("Bottom Wear C")){
            detailimg.setImageResource(R.drawable.jeansman);
        }else if(namabrg.equals("Bottom Wear D")){
            detailimg.setImageResource(R.drawable.rok);
        }else if(namabrg.equals("Bottom Wear ")){
            detailimg.setImageResource(R.drawable.jeansman);
        }else if(namabrg.equals("Bottom Wear (2)")){
            detailimg.setImageResource(R.drawable.jenasmentwo);
        }else if(namabrg.equals("Formals(A)")){
            detailimg.setImageResource(R.drawable.shirtmentwo);
        }else if(namabrg.equals("Formals(B)")){
            detailimg.setImageResource(R.drawable.shirtmenthree);
        }else if(namabrg.equals("Formals(C)")){
            detailimg.setImageResource(R.drawable.shirtmentwo);
        }else if(namabrg.equals("Formals(D)")){
            detailimg.setImageResource(R.drawable.shirtmenthree);
        }else if(namabrg.equals("Laptop Asus")){
            detailimg.setImageResource(R.drawable.laptop);
        }else if(namabrg.equals("HP Iphone")){
            detailimg.setImageResource(R.drawable.hanphoneipong);
        }else if(namabrg.equals("Novel Dilan")){
            detailimg.setImageResource(R.drawable.bookkopi);
        }else if(namabrg.equals("Novel Laksar pelangi")){
            detailimg.setImageResource(R.drawable.bookresep);
        }else if(namabrg.equals("Payung")){
            detailimg.setImageResource(R.drawable.payung);
        }else if(namabrg.equals("Pena")){
            detailimg.setImageResource(R.drawable.pena);
        }

    }
}