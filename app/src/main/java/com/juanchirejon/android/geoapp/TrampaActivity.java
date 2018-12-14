package com.juanchirejon.android.geoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TrampaActivity extends AppCompatActivity {
    public static String EXTRA_RESPUESTA_ES_CORRECTA ="com.juanchirejon.android.geoapp.respuesta_es_correcta";
    public static String EXTRA_SE_MOSTRO_RESPUESTA = "com.juanchirejon.android.geoapp.se_mostro_respuesta";
    private Button mBotonMostarRespuesta;
    private TextView mRespuestaTextView;

    public static boolean respuestaMostrada (Intent result){
        return result.getBooleanExtra(EXTRA_SE_MOSTRO_RESPUESTA, false);
        }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trampa);

        mRespuestaTextView = findViewById(R.id.respuesta_textview);
        mBotonMostarRespuesta =findViewById(R.id.boton_mostrar_respuesta);
        mBotonMostarRespuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                boolean respuestaEsCorrecta = intent.getBooleanExtra(EXTRA_RESPUESTA_ES_CORRECTA, false);
                if(respuestaEsCorrecta){
                    mRespuestaTextView.setText("Cierto");
                }
                else{
                    mRespuestaTextView.setText("Falso");
                }

            }
        });
    }

    private void setSeMostroRespuestaResult (
            boolean seMOstroRespuesta)(
                    Intent datos = new Intent();
                    datos.putExtra(EXTRA_SE_MOSTRO_RESPUESTA, seMostroRespuesta);
                    setResult (RESULT_OK, datos);
            )
}
