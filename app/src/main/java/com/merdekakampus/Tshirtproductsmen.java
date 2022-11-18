package com.merdekakampus;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;

public class Tshirtproductsmen extends AppCompatActivity {

    private DatabaseReference mdatabase, ndatabase;
    private TextView nameproducts,quantity,nameproducts2,quantity2;
    private ImageView tshirt1,tshirt2;
    LinearLayout product1, product2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tshirtproductsmen);

        mdatabase = FirebaseDatabase.getInstance().getReference().child("barang").child("1");
        ndatabase = FirebaseDatabase.getInstance().getReference().child("barang").child("2");
        product1 =  findViewById(R.id.product1);
        product2 = findViewById(R.id.product2);
        nameproducts = findViewById(R.id.nameproducts);
        quantity =  findViewById(R.id.quantity);
        tshirt1 =  findViewById(R.id.tshirt1);
        tshirt2 =  findViewById(R.id.tshirt2);

        nameproducts2 = findViewById(R.id.nameproducts2);
        quantity2 =  findViewById(R.id.quantity2);
        ValueEventListener tshirtA = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Barang brg1 = dataSnapshot.getValue(Barang.class);
                nameproducts.setText(brg1.getNama_barang());
                quantity.setText("Kuantitas :" + String.valueOf(brg1.getKuantitas()));

                product1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Bundle extras = new Bundle ();
                        extras.putString("namabrg",nameproducts.getText().toString());
                        extras.putString ("kuantitasbrg", quantity.getText().toString());
                        Intent intent = new Intent (Tshirtproductsmen.this, DetailActivity.class);
                        intent.putExtras (extras);
                        startActivity (intent);

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        mdatabase.addValueEventListener(tshirtA);
       ValueEventListener tshirtB = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Barang brg2 = dataSnapshot.getValue(Barang.class);
                nameproducts2.setText(brg2.getNama_barang().toString());
                quantity2.setText("Kuantitas :" + String.valueOf(brg2.getKuantitas()));

                product2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Bundle extras = new Bundle ();
                        extras.putString("namabrg",nameproducts2.getText().toString());
                        extras.putString ("kuantitasbrg", quantity2.getText().toString());
                        Intent intent = new Intent (Tshirtproductsmen.this, DetailActivity.class);
                        intent.putExtras (extras);
                        startActivity (intent);

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        ndatabase.addValueEventListener(tshirtB);
    }
}