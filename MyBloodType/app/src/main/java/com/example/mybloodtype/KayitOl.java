package com.example.mybloodtype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class KayitOl extends AppCompatActivity {

    EditText editTxtAd;
    EditText editTxtSoyad;
    EditText editTxtTelefon;
    EditText editTxtKullaniciAdi;
    EditText editTxtSifre;
    Button btnKayit;

    String ad, soyad,telefon,kullaniciAdi, sifre , kanGrubu;

    //Spinner içerisine koyacağımız veriler tanımlanır
    private String[] bloodType = {"0 RH+", "0 RH-", "A RH+", "A RH-", "B RH+", "B RH-", "AB RH+", "AB RH-"};

    //Spinner'ları ve Adapter'ler tanımlanır
    private Spinner spinnerBloodType;
    private ArrayAdapter<String> dataAdapterForBloodType;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);

        editTxtAd = (EditText)findViewById(R.id.editTxtAd);
        editTxtSoyad = (EditText)findViewById(R.id.editTxtSoyad);
        editTxtTelefon = (EditText)findViewById(R.id.editTxtTelefon);
        editTxtKullaniciAdi = (EditText)findViewById(R.id.editTxtKullaniciAdi);
        editTxtSifre = (EditText)findViewById(R.id.editTxtSifre);
        btnKayit = (Button)findViewById(R.id.btnKayit);

        //xml kısmında hazırladığımğız spinnerları burda tanımladıklarımızla eşleştiriyoruz.
        spinnerBloodType = (Spinner) findViewById(R.id.spinnerKanGrubu);

        //Spinner'lar için adapterleri hazırlıyoruz.
        dataAdapterForBloodType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bloodType);

        //Listelenecek verilerin görünümünü belirliyoruz.
        dataAdapterForBloodType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Hazırladğımız Adapter'leri Spinner'lara ekliyoruz.
        spinnerBloodType.setAdapter(dataAdapterForBloodType);

        // Listelerden bir eleman seçildiğinde yapılacakları tanımlıyoruz.
        spinnerBloodType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //Seçilen il ve ilçeyi ekranda gösteriyoruz.
                Toast.makeText(getBaseContext(), ""+spinnerBloodType.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getBaseContext(), ""+ "Kan Grubunuzu Seçiniz.", Toast.LENGTH_SHORT).show();
            }
        });


        //butona basıldığında yapılması gereken
        btnKayit.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // edittext lerden değerler alındı
                ad = editTxtAd.getText().toString();
                soyad = editTxtSoyad.getText().toString();
                telefon = editTxtTelefon.getText().toString();
                kullaniciAdi = editTxtKullaniciAdi.getText().toString();
                sifre = editTxtSifre.getText().toString();

                //boşluk kontrolü yapıldı
                if(ad.matches("") ){
                    Toast.makeText(getApplicationContext(), "Ad Bölümü Boş Bırakılamaz.", Toast.LENGTH_LONG).show();
                }
                else if(soyad.matches("")){
                    Toast.makeText(getApplicationContext(), "Soyad Bölümü Boş Bırakılamaz", Toast.LENGTH_LONG).show();
                }
                else if(telefon.matches("")){
                    Toast.makeText(getApplicationContext(), "Telefon Bölümü Boş Bırakılamaz", Toast.LENGTH_LONG).show();
                }
                else if(kullaniciAdi.matches("")){
                    Toast.makeText(getApplicationContext(), "Kullanıcı Adı Bölümü Boş Bırakılamaz", Toast.LENGTH_LONG).show();
                }
                else if(sifre.matches("")){
                    Toast.makeText(getApplicationContext(), "Şifre Bölümü Boş Bırakılamaz", Toast.LENGTH_LONG).show();
                }
                else{ //uzunluk kontrolü yapıldı
                    if(telefon.length() != 11){
                        Toast.makeText(getApplicationContext(), "11 Basamaklı Telefon Numaranızı Giriniz", Toast.LENGTH_LONG).show();
                    }
                    else if(sifre.length() != 6 ){
                        Toast.makeText(getApplicationContext(), "6 Basamaklı Şifrenizi Giriniz", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Intent intent=new Intent(getApplicationContext(),Profil.class);
                        //veriler bir sonraki sayfaya aktarıldı
                        intent.putExtra("ad",ad);
                        intent.putExtra("soyad",soyad);
                        intent.putExtra("telefon",telefon);
                        intent.putExtra("kullaniciAdi",kullaniciAdi);
                        intent.putExtra("şifre",sifre);
                        intent.putExtra("kanGrubu", String.valueOf(spinnerBloodType.getSelectedItem()));  //spinner dan kan grubunu bir sonraki sayfaya aktarma
                        startActivity(intent);
                    }
                }

            }
        }));
    }
}
