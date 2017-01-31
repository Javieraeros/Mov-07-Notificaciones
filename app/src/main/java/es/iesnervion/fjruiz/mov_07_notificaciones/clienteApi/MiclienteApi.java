package es.iesnervion.fjruiz.mov_07_notificaciones.clienteApi;


import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;

import es.iesnervion.fjruiz.mov_07_notificaciones.Model.Persona;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MiclienteApi {
    private Retrofit miRetrofit;
    private RestInterface service;
    private PersonaCallback pc;
    private Context miContexto;

    public MiclienteApi(Context miContexto){
        this.miContexto=miContexto;
        miRetrofit=new Retrofit.Builder().baseUrl("https://personas.fjruiz.ciclo.iesnervion.es")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service=miRetrofit.create(RestInterface.class);
        pc=new PersonaCallback(this.miContexto);
    }

    public void getPersonas(String auth){
        service.getPersonas(auth).enqueue(pc);
    }
}
