package cl.jav.desafiopreguntadinamica;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



public class PreguntaFragment extends Fragment {
    private static final String TAG = "PreguntaFragment";

    int radioButtonValue = 0;
    private TextView preguntaView, categoriaView;
    private RadioGroup grupoRespuestasView;
    private RadioButton respuestaUno, respuestaDos, respuestaTres,
            respuestaCuatro;

    private Button btnConsultaRespuesta;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {


        Log.d(TAG, "onCreateView ");

        View inflate = inflater.inflate(R.layout.fragment_pregunta, container,
                false);
        initViews(inflate);

        if (getArguments() != null) {
            Bundle bundle = getArguments();
            String question = bundle.getString("PREGUNTA");
            String category = bundle.getString("CATEGORIA");
            String correctAnswer = bundle.getString("RESPUESTA_CORRECTA");
            ArrayList<String> incorrectAnswers = bundle.getStringArrayList("RESPUESTAS_INCORRECTAS");


            preguntaView.setText(question);
            categoriaView.setText(category);
            Log.d(TAG, correctAnswer);
            if (incorrectAnswers != null) {

                ArrayList<String> answers = new ArrayList<>(incorrectAnswers);
                answers.add(correctAnswer);
                Collections.shuffle(answers);

                //RECORREMOS EL ARREGLO DE STRINGS "RESPUESTAS INCORRECTAS" DE NUESTRA API DE DATOS
                for (int i = 0; i < answers.size(); i++) {
                    switch (i) {
                        case 0:
                            respuestaUno.setText(answers.get(i));
                            break;
                        case 1:
                            respuestaDos.setText(answers.get(i));
                            break;
                        case 2:
                            respuestaTres.setText(answers.get(i));
                            break;
                        case 3:
                            respuestaCuatro.setText(answers.get(i));
                            break;
                    }
                }
            }


            btnConsultaRespuesta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Respuesta correcta : " + correctAnswer, Toast.LENGTH_LONG).show();
                }
            });
        }

        return inflate;
    }

    private void initViews(View view) {
        preguntaView = view.findViewById(R.id.pregunta);
        categoriaView = view.findViewById(R.id.categoria);
        grupoRespuestasView = view.findViewById(R.id.radioGrupoRespuestas);
        respuestaUno = view.findViewById(R.id.radioRespuestaUno);
        respuestaDos = view.findViewById(R.id.radioRespuestaDos);
        respuestaTres = view.findViewById(R.id.radioRespuestaTres);
        respuestaCuatro = view.findViewById(R.id.radioRespuestaCuatro);
        btnConsultaRespuesta = view.findViewById(R.id.btnConsultaRespuesta);
    }

    public static PreguntaFragment newInstance(String pregunta,
                                               String categoria,
                                               String respuestaCorrecta,
                                               ArrayList<String> respuestasIncorrectas) {
        PreguntaFragment fragment = new PreguntaFragment();
        Bundle arguments = new Bundle();
        arguments.putString("PREGUNTA", pregunta);
        arguments.putString("CATEGORIA", categoria);
        arguments.putString("RESPUESTA_CORRECTA", respuestaCorrecta);
        arguments.putStringArrayList("RESPUESTAS_INCORRECTAS", respuestasIncorrectas);
        fragment.setArguments(arguments);
        return fragment;
    }
}
