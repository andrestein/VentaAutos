package com.example.lenovo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtPrecio;
    private Button btnCalcular;
    private RadioButton radioBMW,radioAudi,radioToyota;
    private CheckBox checkSunroof,checkNitro,checkPolarizado;
    private RadioGroup rg;
    private double precio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initComponents();
        autoSeleccionado();
        

    }

    private void autoSeleccionado(){
        if(rg.getCheckedRadioButtonId()==R.id.radioBtnBMW){
            precio =40000;
            txtPrecio.setText(""+precio);
        }else if(rg.getCheckedRadioButtonId() == R.id.radioBtnAudi){
            precio =40000;
            txtPrecio.setText(""+precio);
        }else if(rg.getCheckedRadioButtonId() == -1){
            Toast.makeText(getApplicationContext(), "Necesita seleccionar una marca de auto",Toast.LENGTH_SHORT);
        }
        else{
            precio =40000;
            txtPrecio.setText(""+precio);
        }
    }

    private void initComponents(){
        precio =0;
        rg= (RadioGroup)findViewById(R.id.rg);
        radioBMW = (RadioButton)findViewById(R.id.radioBtnBMW);
        radioAudi= (RadioButton)findViewById(R.id.radioBtnAudi);
        radioToyota= (RadioButton)findViewById(R.id.radioBtnToyota);
        checkSunroof=(CheckBox)findViewById(R.id.checkSunroof);
        checkNitro=(CheckBox)findViewById(R.id.checkNitro);
        checkPolarizado=(CheckBox)findViewById(R.id.checkPolarizado);
        txtPrecio = (EditText)findViewById(R.id.txtPecio);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);
    }
}
