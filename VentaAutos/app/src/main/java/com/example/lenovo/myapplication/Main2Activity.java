package com.example.lenovo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private MainActivity mainActivity;
    private Button btnFactura;
    private EditText txtFactura;
    private String marca;
    private String sunroof;
    private String nitro;
    private String polarizado;
    private double precio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initComponents();

        btnFactura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(analisis(marca,sunroof,polarizado,nitro) == 8) {
                    txtFactura.setText("Señor usuario su eleccion fue un auto de marca " + marca + " con sunroof, nitro y polarizado incluido");
                }if(analisis(marca,sunroof,polarizado,nitro) == 7) {
                    txtFactura.setText("Señor usuario su eleccion fue un auto de marca "+marca+" con sunroof y polarizado incluido");
                }if(analisis(marca,sunroof,polarizado,nitro) == 6) {
                    txtFactura.setText("Señor usuario su eleccion fue un auto de marca " + marca + " con nitro y sunroof incluido");
                }if(analisis(marca,sunroof,polarizado,nitro) == 5) {
                    txtFactura.setText("Señor usuario su eleccion fue un auto de marca "+marca+" con nitro y polarizado incluido");
                }if(analisis(marca,sunroof,polarizado,nitro) == 4) {
                    txtFactura.setText("Señor usuario su eleccion fue un auto de marca "+marca+" con sunroof incluido");
                }if(analisis(marca,sunroof,polarizado,nitro) == 3) {
                    txtFactura.setText("Señor usuario su eleccion fue un auto de marca "+marca+" con polarizado incluido");
                }if(analisis(marca,sunroof,polarizado,nitro) == 2) {
                    txtFactura.setText("Señor usuario su eleccion fue un auto de marca "+marca+" con sunroof y polarizado incluido");
                }if(analisis(marca,sunroof,polarizado,nitro) == 1) {
                    Toast.makeText(getApplicationContext(), "Debe seleccionar una marca para poder realizar la factura ", Toast.LENGTH_SHORT).show();
                }if(analisis(marca,sunroof,polarizado,nitro) == 0) {
                    Toast.makeText(getApplicationContext(), "Debe seleccionar una marca para poder realizar la factura ", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }

    private int analisis(String marca,String sunroof,String polarizado,String nitro){
        int cont;
        if(marca != "" && sunroof != "" && polarizado != "" && nitro != ""){
            return 8;
        }
        if(marca != "" && sunroof != "" && polarizado != ""){
            return 7;
        }
        if(marca != "" && sunroof != "" && nitro != ""){
            return 6;
        }
        if(marca != "" && nitro != "" && polarizado != ""){
            return 5;
        }
        if(marca != "" && sunroof != ""){
            return 4;
        }
        if (marca != "" && polarizado != ""){
            return 3;
        }
        if (marca != "" && nitro != ""){
            return 2;
        }
        if(marca != ""){
            return 1;
        }
        else{
            return 0;
        }
    }

    private void initComponents(){
        Bundle recup=getIntent().getExtras();
        if(recup != null){
            marca = recup.getString("marca");
            sunroof = recup.getString("sunroof");
            polarizado = recup.getString("polarizado");
            nitro =recup.getString("nitro");
            precio = recup.getDouble("precio");
        }
        btnFactura = (Button)findViewById(R.id.btnFactura);
        txtFactura = (EditText)findViewById(R.id.txtFactura);
    }
}
