package es.iesnervion.fjruiz.mov_07_notificaciones.clienteApi;


import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;

import es.iesnervion.fjruiz.mov_07_notificaciones.Model.Persona;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MiclienteApi implements InterfazComunicadora {
    private Retrofit miRetrofit;
    private RestInterface service;
    private PersonaCallback pc;
    private Context miContexto;
    private InterfazComunicadora2 enviador;

    public MiclienteApi(Context miContexto){
        this.miContexto=miContexto;
        if (miContexto instanceof InterfazComunicadora2) {
            enviador = (InterfazComunicadora2) miContexto;
            miRetrofit=new Retrofit.Builder().baseUrl("https://personas.fjruiz.ciclo.iesnervion.es").
                    addConverterFactory(GsonConverterFactory.create())
                    .build();

            service=miRetrofit.create(RestInterface.class);
            PersonaCallback pc=new PersonaCallback(this.miContexto);
        } else {
            throw new RuntimeException(miContexto.toString()
                    + " must implement InterfazComunicadora2");
        }
    }

    public void getPersonas(){
        service.getPersonas().enqueue(pc);
    }

    public void cuandoAcabe(Persona[] miArray){
        enviador.cuandoAcabe2(miArray);
    }
}
