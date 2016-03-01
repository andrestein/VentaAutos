package com.example.lenovo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
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


        rg.ch

        btnCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(autoSeleccionado() != "") {
                        txtPrecio.setText(autoSeleccionado());
                        mejoras();
                    }else{
                        Toast.makeText(getApplicationContext(),"No se ha seleccionado ninguna marca",Toast.LENGTH_SHORT);
                    }
                }
            });
    }

    private void mejoras(){
        if(checkSunroof.isChecked()){
            precio =+ 10000;
        }if(checkNitro.isChecked()){
            precio =+ 15000;
        }if(checkPolarizado.isChecked()){
            precio =+ 8000;
        }
        txtPrecio.setText("$ " + precio);
    }

    private String autoSeleccionado(){
        if(rg.getCheckedRadioButtonId()==R.id.radioBtnBMW){
            precio= 40000;
            return "$"+precio;
        }else if(rg.getCheckedRadioButtonId() == R.id.radioBtnAudi){
            precio=50000;
            return "$"+precio;
        }
        else if(rg.getCheckedRadioButtonId() == R.id.radioBtnToyota){
            precio= 30000;
            return "$"+precio;
        }else{
            return "";
        }
    }

    private void initComponents(){
        precio=0;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
