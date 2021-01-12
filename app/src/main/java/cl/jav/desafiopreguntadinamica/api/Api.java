package cl.jav.desafiopreguntadinamica.api;

import cl.jav.desafiopreguntadinamica.pojos.PreguntasLista;
import retrofit2.Call;
import retrofit2.http.GET;


public interface Api {
    @GET("api.php?amount=20&category=15&difficulty=easy")
    Call<PreguntasLista> getAllQuestions();
}
