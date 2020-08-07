package com.example.mybloodtype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GirisYap extends AppCompatActivity {

    EditText editTxtKullaniciAdi;
    EditText editTxtSifre;
    Button btnGiris;
    String kullaniciAdi,sifre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_yap);

        editTxtKullaniciAdi = (EditText)findViewById(R.id.editTxtKullaniciAdi);
        editTxtSifre = (EditText)findViewById(R.id.editTxtSifre);
        btnGiris = (Button)findViewById(R.id.btnGiris);

        btnGiris.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kullaniciAdi = editTxtKullaniciAdi.getText().toString();
                sifre = editTxtSifre.getText().toString();

                if(kullaniciAdi.matches("") ){
                    Toast.makeText(getApplicationContext(), "Kullanıcı Adı Bölümü Boş Bırakılamaz.", Toast.LENGTH_LONG).show();
                }
                else if(sifre.matches("")){
                    Toast.makeText(getApplicationContext(), "Şifre Bölümü Boş Bırakılamaz", Toast.LENGTH_LONG).show();
                }
                else { //uzunluk kontrolü yapıldı
                    if (sifre.length() != 6) {
                        Toast.makeText(getApplicationContext(), "6 Basamaklı Şifrenizi Giriniz", Toast.LENGTH_LONG).show();
                    } else {
                        Intent intent = new Intent(getApplicationContext(), Profil.class);
                        //veriler bir sonraki sayfaya aktarıldı
                        intent.putExtra("kullaniciAdi", kullaniciAdi);
                        intent.putExtra("şifre", sifre);
                        startActivity(intent);
                    }
                }
            }
        }));
    }
}
