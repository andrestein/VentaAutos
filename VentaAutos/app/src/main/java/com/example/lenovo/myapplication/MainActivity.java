package com.example.lenovo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtPrecio;
    private String marca;
    private String sunroof;
    private String nitro;
    private String polarizado;
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


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                autoSeleccionado(checkedId);
            }
        });

        checkSunroof.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    setPrecio(getPrecio()+10000);
                    txtPrecio.setText("$ " + precio);
                    setSunroof("Sunroof");
                }else{
                    setPrecio(getPrecio()-10000);
                    txtPrecio.setText("$ " + precio);
                    setSunroof("");
                }
            }
        });

        checkNitro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    setPrecio(getPrecio()+5000);
                    txtPrecio.setText("$ " + precio);
                    setNitro("Nitro");
                }else{
                    setPrecio(getPrecio()-5000);
                    txtPrecio.setText("$ " + precio);
                    setNitro("");
                }
            }
        });

        checkPolarizado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    setPrecio(getPrecio()+8000);
                    txtPrecio.setText("$ " + precio);
                    setPolarizado("Polarizado");
                }else{
                    setPrecio(getPrecio()-8000);
                    txtPrecio.setText("$ " + precio);
                    setPolarizado("");
                }
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(getApplicationContext(), Main2Activity.class);
                intento.putExtra("marca",marca);
                intento.putExtra("sunroof",sunroof);
                intento.putExtra("polarizado",polarizado);
                intento.putExtra("nitro",nitro);
                intento.putExtra("precio",precio);
                startActivity(intento);
            }
        });
    }

    private void autoSeleccionado(int checkedId){
        if (checkedId == R.id.radioBtnBMW){
            precio= 40000;
            txtPrecio.setText("$ "+precio );
            setMarca("BMW");
        }else if(checkedId == R.id.radioBtnAudi){
            precio= 50000;
            txtPrecio.setText("$ "+precio );
            setMarca("Audi");
        }else if(checkedId == R.id.radioBtnToyota){
            precio= 30000;
            txtPrecio.setText("$ "+precio );
            setMarca("Toyota");
        }else{
            Toast.makeText(getApplicationContext(),"Debe elegir una marca",Toast.LENGTH_SHORT).show();
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSunroof() {
        return sunroof;
    }

    public void setSunroof(String sunroof) {
        this.sunroof = sunroof;
    }

    public String getNitro() {
        return nitro;
    }

    public void setNitro(String nitro) {
        this.nitro = nitro;
    }

    public String getPolarizado() {
        return polarizado;
    }

    public void setPolarizado(String polarizado) {
        this.polarizado = polarizado;
    }
}
