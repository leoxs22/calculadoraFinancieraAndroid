package com.leoxs.gcbully;


import java.util.GregorianCalendar;

public class Calculator {

    public static double calcularCapital(double credito, double tasa, long dias){
        double resultado;
        resultado= credito/(1-((tasa/(100*30))*dias));
        return resultado;
    }

    public static long restarDias(GregorianCalendar fechaAnterior, GregorianCalendar fechaPosterior){
        long diferencia = fechaPosterior.getTimeInMillis() - fechaAnterior.getTimeInMillis();
        long resultado = diferencia / (1000*60*60*24);
        return resultado;
    }

    public static double calcularCredito(double capital, double tasa, long dias){
        double resultado;
        //divido por 100 para pasar el porcentaje
        resultado= capital*(1-((tasa/(100*30))*dias));
        return resultado;
    }

    public static double calcularDescuento(double capital, double credito){
        return capital-credito;
    }

}
