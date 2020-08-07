package com.example.mybloodtype;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Cagri extends AppCompatActivity {

    Button btnCagriGönder;
    String kanGrubu;

    //Spinner içerisine koyacağımız veriler tanımlanır
    private String[] bloodType = {"0 RH+", "0 RH-", "A RH+", "A RH-", "B RH+", "B RH-", "AB RH+", "AB RH-"};

    //Spinner'ları ve Adapter'ler tanımlanır
    private Spinner spinnerBloodType;
    private ArrayAdapter<String> dataAdapterForBloodType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cagri);

        btnCagriGönder = (Button)findViewById(R.id.btnCagriGönder);

        //xml kısmında hazırladığımğız spinnerları burda tanımladıklarımızla eşleştiriyoruz.
        spinnerBloodType = (Spinner) findViewById(R.id.spinnerKan);

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


    }
}
