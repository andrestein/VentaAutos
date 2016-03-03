package com.example.lenovo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    private MainActivity mainActivity;
    private Button btnFactura;
    private EditText txtMarca;
    private EditText txtMejora;
    private EditText txtPrecio;
    private String marca="";
    private String sunroof="";
    private String nitro="";
    private String polarizado="";
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
                txtMarca.setText(marca);
                txtMejora.setText(" "+sunroof +" "+polarizado+" "+nitro+" ");
                txtPrecio.setText("$ "+precio);
            }

        });

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
        if(sunroof == null){
            sunroof=" ";
        }
        if(polarizado ==null){
            polarizado=" ";
        }
        if(nitro == null){
            nitro =" ";
        }
        btnFactura = (Button)findViewById(R.id.btnFactura);
        txtMarca = (EditText)findViewById(R.id.txtMarca);
        txtMejora = (EditText)findViewById(R.id.txtMejoras);
        txtPrecio = (EditText)findViewById(R.id.txtPrecio);
    }
}
