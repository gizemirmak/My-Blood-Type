package com.example.mybloodtype;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Profil extends AppCompatActivity {

    TextView txtKullaniciAdi;
    TextView txtAdSoyad;
    TextView txtTelefon;
    TextView txtKanGrubu;
    Button btnCagriOlustur;

    String kullaniciAdi, ad, soyad, telefon, kanGrubu;

    // Menü inflater, 1 activity calıstırıyor
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.profil_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.itemCikis){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.itemCikis){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        Bundle extras = getIntent().getExtras();


        txtKullaniciAdi = (TextView)findViewById(R.id.txtKullaniciAdi);
        txtAdSoyad = (TextView)findViewById(R.id.txtAdSoyad);
        txtTelefon = (TextView)findViewById(R.id.txtTelefon);
        txtKanGrubu = (TextView)findViewById(R.id.txtKanGrubu);
        btnCagriOlustur = (Button)findViewById(R.id.btnCagriOlustur);

        //bir önceki ekrandaki verileri çekme
        kullaniciAdi = extras.getString("kullaniciAdi");
        ad = extras.getString("ad");
        soyad = extras.getString("soyad");
        telefon = extras.getString("telefon");
        kanGrubu = extras.getString("kanGrubu");

        //textview lere yazma
        txtKullaniciAdi.setText(kullaniciAdi);
        txtAdSoyad.setText(ad + " " + soyad );
        txtTelefon.setText(telefon);
        txtKanGrubu.setText(kanGrubu);

        btnCagriOlustur.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Cagri.class);
                //veriler bir sonraki sayfaya aktarıldı
                intent.putExtra("kullaniciAdi", kullaniciAdi);
                intent.putExtra("ad", ad);
                intent.putExtra("soyad", soyad);
                intent.putExtra("telefon", telefon);
                intent.putExtra("kanGrubu",kanGrubu);
                startActivity(intent);

            }
        }));



    }
}
