package com.example.mybloodtype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnGirisYap;
    Button btnKayitOl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGirisYap = (Button)findViewById(R.id.btnGirisYap);
        btnKayitOl = (Button)findViewById(R.id.btnKayit);


        //butona tıklanınca yapılacak olan
        btnGirisYap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GirisYap.class);    //main den girişyap a geç
                startActivity(intent);
            }
        });

        btnKayitOl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KayitOl.class);
                startActivity(intent);
            }
        });
    }

}