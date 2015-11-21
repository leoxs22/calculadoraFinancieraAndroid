package com.leoxs.gcbully;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.text.ParseException;
import java.util.GregorianCalendar;

public class CreditoActivity  extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.por_credito);
        setUpViews();
    }

    public void irAMain(View v){
        startActivity(new Intent(CreditoActivity.this, MainActivity.class));
    }

    public void calcularPorCredito(View v) throws ParseException {
        GregorianCalendar fechaAnt = obtenerGregorianCalendar(txtFechaAnterior);
        GregorianCalendar fechaPost = obtenerGregorianCalendar(txtFechaPosterior);
        long dias = Calculator.restarDias(fechaAnt, fechaPost);
        double capital = Calculator.calcularCapital(toDouble(txtCredito.getText()), toDouble(txtTasa.getText()), dias);
        double descuento = Calculator.calcularDescuento(capital,toDouble(txtCredito.getText()));

        txtDias.setText(Long.toString(dias));
        txtCapital.setText(Double.toString(capital));
        txtDescuento.setText(Double.toString(descuento));
    }
}


