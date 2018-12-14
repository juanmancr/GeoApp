package com.juanchirejon.android.geoapp.model;

/**
 * Created by ALUMNOS on 16/10/2018.
 */
public class Pregunta {
    private int midResTexto;
    private boolean mVerdadera;

    public Pregunta(int idRestexto, boolean verdadera){
        midResTexto = idRestexto;
        mVerdadera = verdadera;
    }

    public  int getIdResTexto(){
        return midResTexto;
    }
    public void setIdResTexto(int idResTexto){
        midResTexto = idResTexto;
    }
    public boolean isVerdadera(){
        return mVerdadera;
    }
    public void setVerdadera(boolean verdadera){
        mVerdadera = verdadera;
    }


}
