package com.example.calculodesueldotablet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txthoras, txtdias, txtsueldobase, txtvalorhora;
    private CheckBox checkBoxPago, checkBoxDcto;
    private RadioGroup radiogrp;
    private RadioButton radiobuttonred, radioButtonsinred;
    private Button btnLimpiar, btnCalcular;
    private TextView lbl_Pago, lbl_Pagocondcto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txthoras = (EditText)findViewById(R.id.txthoras);
        txtdias = (EditText)findViewById(R.id.txtdias);
        txtsueldobase = (EditText)findViewById(R.id.txtsueldobase);
        txtvalorhora = (EditText)findViewById(R.id.txtvalorhora);
        checkBoxPago = (CheckBox)findViewById(R.id.checkBoxPago);
        checkBoxDcto = (CheckBox)findViewById(R.id.checkBoxDcto);
        radiogrp = (RadioGroup)findViewById(R.id.radiogrp);
        radiobuttonred = (RadioButton) findViewById(R.id.radiobuttonred);
        radioButtonsinred = (RadioButton) findViewById(R.id.radioButtonsinred);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        lbl_Pago = (TextView) findViewById(R.id.lbl_Pago);
        lbl_Pagocondcto = (TextView) findViewById(R.id.lbl_Pagocondcto);
    }
    public void calcular (View view){
        int horas = Integer.parseInt(txthoras.getText().toString());
        int dias = Integer.parseInt(txtdias.getText().toString());
        double sueldobase = Integer.parseInt(txtsueldobase.getText().toString());
        int valorhora = Integer.parseInt(txtvalorhora.getText().toString());
        int horas_mensuales = horas*dias;
        double pago;
        pago = ((horas_mensuales)*valorhora) + sueldobase;
        double descuento = 0.00;

        if(checkBoxPago.isChecked())
        {
            lbl_Pago.setText(String.valueOf(pago));
        }
        if(checkBoxDcto.isChecked() && pago >1000)
        {
            descuento = pago - (pago*0.1);
            lbl_Pagocondcto.setText(String.valueOf(descuento));
        }
        if(radiogrp.getCheckedRadioButtonId() == R.id.radiobuttonred)
        {
            int pago_redondeo = (int)Math.round(pago);
            lbl_Pago.setText(String.valueOf((pago_redondeo)));
            int dcto_redondeo = (int)Math.round(descuento);
            lbl_Pagocondcto.setText(String.valueOf((dcto_redondeo)));
        }
    }

    public void limpiar(View view){
        txthoras.setText("");
        txtdias.setText("");
        txtsueldobase.setText("");
        txtvalorhora.setText("");
        checkBoxPago.setChecked(false);
        checkBoxDcto.setChecked(false);
        radiobuttonred.setChecked(false);
        radioButtonsinred.setChecked(false);
        lbl_Pago.setText("");
        lbl_Pagocondcto.setText("");}
}