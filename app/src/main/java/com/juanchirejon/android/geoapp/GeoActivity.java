package com.juanchirejon.android.geoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.juanchirejon.android.geoapp.model.BancoPreguntas;
import com.juanchirejon.android.geoapp.model.Pregunta;

public class GeoActivity extends AppCompatActivity {
    private Button mBotonCierto;
    private Button mBotonFalso;
    private Button mBotonAnterior;
    private Button mBotonSiguiente;
    private final String KEY_POSICION_ACTUAL= "posicion_actual";
    private TextView mTextoPregunta;
    private BancoPreguntas banco;
    private Pregunta mPreguntaActual;
    private Button mBotonVerRespuesta;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);

        crearBancoDePreguntas();
        mPreguntaActual = banco.get(0);

        mTextoPregunta = (TextView) findViewById(R.id.texto_pregunta);
        mBotonCierto = (Button) findViewById(R.id.BotonCierto);
        mBotonFalso = (Button) findViewById(R.id.BotonFalso);
        mBotonAnterior = (Button) findViewById(R.id.BotonAnterior);
        mBotonVerRespuesta=(Button) findViewById(R.id.botonVerRespuesta);
        mBotonSiguiente = (Button) findViewById(R.id.BotonSiguiente);
            if(savedInstanceState != null){
                int posicion = savedInstanceState.getInt(KEY_POSICION_ACTUAL);
                mPreguntaActual = banco.get(posicion);
            }

        mBotonCierto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VerficarRespuesta(true);
            }
        });

        mBotonFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VerficarRespuesta(false);
            }
        });

        mBotonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPreguntaActual = banco.previous();
                actualizarPregunta();
            }
        });
        mBotonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPreguntaActual = banco.next();
                actualizarPregunta();
            }
        });
        mBotonVerRespuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GeoActivity.this, TrampaActivity.class);


                boolean laRespuestaEsCorrecta= mPreguntaActual.isVerdadera();
                intent.putExtra(TrampaActivity.EXTRA_RESPUESTA_ES_CORRECTA,laRespuestaEsCorrecta);
                startActivity(intent);
            }
        });
    }

    private void crearBancoDePreguntas() {
        banco = new BancoPreguntas();
        banco.add(new Pregunta(R.string.texto_pregunta_1,false));
        banco.add(new Pregunta(R.string.texto_pregunta_2, true));
        banco.add(new Pregunta(R.string.texto_pregunta_3, true));
        banco.add(new Pregunta(R.string.texto_pregunta_4,true));
        banco.add(new Pregunta(R.string.texto_pregunta_5, false));
    }

    private void actualizarPregunta() {
          mTextoPregunta.setText(mPreguntaActual.getIdResTexto());
    }

    private void VerficarRespuesta(boolean botonOprimido){
       boolean respuestaEsVerdadera = mPreguntaActual.isVerdadera();
        if (botonOprimido == respuestaEsVerdadera) {
            Toast.makeText(GeoActivity.this, R.string.texto_correcto,Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(GeoActivity.this,R.string.texto_incorrecto,Toast.LENGTH_SHORT).show();
        }
    }

}
