package com.leoxs.gcbully;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;

public class MyEditTextDatePicker  implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    EditText _editText;
    private int _day;
    private int _month;
    private int _birthYear;
    private MainActivity _context;

    public MyEditTextDatePicker(MainActivity context, int editTextViewID)
    {
        Activity act = (Activity)context;
        this._editText = (EditText)act.findViewById(editTextViewID);
        this._editText.setOnClickListener(this);
        this._context = context;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        _birthYear = year;
        _month = monthOfYear;
        _day = dayOfMonth;
        try {
            updateDisplay();
        } catch (ParseException e) {
            Toast.makeText(_context,"Error en la fecha",Toast.LENGTH_SHORT);
        }
    }
    @Override
    public void onClick(View v) {
        DatePickerDialog dialog =  new DatePickerDialog(_context, this, 2013, 2, 18);
        dialog.show();

    }

    // updates the date in the birth date EditText
    private void updateDisplay() throws ParseException {

        _editText.setText(new StringBuilder()
                // Month is 0 based so add 1
                .append(_day).append("/").append(_month + 1).append("/").append(_birthYear).append(" "));
        _context.setDias();
    }
}