package com.leoxs.gcbully;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView txtFechaAnterior;
    TextView txtFechaPosterior;
    TextView txtDias;
    TextView txtCapital;
    TextView txtTasa;
    TextView txtDescuento;
    TextView txtCredito;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Calendar myCalendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpViews();

    }

    public void setUpViews() {
        txtFechaAnterior = (TextView) findViewById(R.id.fechaAnterior);
        txtFechaPosterior = (TextView) findViewById(R.id.fechaPosterior);
        txtDias = (TextView) findViewById(R.id.dias);
        txtCapital = (TextView) findViewById(R.id.capital);
        txtTasa = (TextView) findViewById(R.id.tasa);
        txtDescuento = (TextView) findViewById(R.id.descuento);
        txtCredito = (TextView) findViewById(R.id.credito);

        txtFechaAnterior.setText(sdf.format(Calendar.getInstance().getTime()));

        new MyEditTextDatePicker(this,R.id.fechaPosterior);
        new MyEditTextDatePicker(this,R.id.fechaAnterior);
    }

    public void irACredito(View v) {
        startActivity(new Intent(MainActivity.this, CreditoActivity.class));
    }

    public void calcular(View v) throws ParseException {


        double credito = Calculator.calcularCredito(toDouble(txtCapital.getText()), toDouble(txtTasa.getText()), Long.parseLong(txtDias.getText().toString()));
        double descuento = Calculator.calcularDescuento(toDouble(txtCapital.getText()), credito);


        txtCredito.setText(Double.toString(credito));
        txtDescuento.setText(Double.toString(descuento));
    }

    public GregorianCalendar obtenerGregorianCalendar(TextView fecha) throws ParseException {
        Date date = sdf.parse(fecha.getText().toString());
        GregorianCalendar fecha2 = new GregorianCalendar();
        fecha2.setTime(date);
        return fecha2;
    }

    public double toDouble(CharSequence numero) {
        return Double.parseDouble(numero.toString());
    }

    public  void setDias() throws ParseException {
        GregorianCalendar fechaAnt = obtenerGregorianCalendar(txtFechaAnterior);
        GregorianCalendar fechaPost = obtenerGregorianCalendar(txtFechaPosterior);
        long dias = Calculator.restarDias(fechaAnt, fechaPost);
        txtDias.setText(Long.toString(dias));

    }
}

