package com.merdekakampus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Admin_input extends AppCompatActivity {
    private EditText idbarang, quantity;
    private Button btnsubmit;
    private DatabaseReference mDatabase,barangreference;
    private Integer intlama = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_input);

        idbarang = findViewById(R.id.idbarang);
        quantity = findViewById(R.id.quantity);
        btnsubmit = findViewById(R.id.btnsubmit);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        btnsubmit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                barangreference = FirebaseDatabase.getInstance().getReference().child("barang").child(idbarang.getText().toString());

                ValueEventListener baranglistener = new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Barang barang = snapshot.getValue(Barang.class);
                        intlama = Integer.parseInt(String.valueOf(barang.kuantitas)) ;

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                };
                barangreference.addValueEventListener(baranglistener);


                HashMap<String, Object> result = new HashMap<>();

                mDatabase.child("barang").child(idbarang.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Log.d("okok", snapshot.getRef().toString());
                        result.put("kuantitas", intlama + Integer.parseInt(quantity.getText().toString()));
                        mDatabase.child("barang").child(idbarang.getText().toString()).updateChildren(result).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(getApplicationContext(),
                                        "Berhasil menambahkan barang", Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }

}