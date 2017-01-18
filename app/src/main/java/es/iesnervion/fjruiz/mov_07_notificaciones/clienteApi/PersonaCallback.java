package es.iesnervion.fjruiz.mov_07_notificaciones.clienteApi;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import es.iesnervion.fjruiz.mov_07_notificaciones.Model.Persona;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonaCallback implements Callback<List<Persona>> {

    private InterfazComunicadora enviador;
    private Context miContexto;

    public PersonaCallback(Context miContexto){
        this.miContexto=miContexto;
        if (miContexto instanceof InterfazComunicadora) {
            enviador = (InterfazComunicadora) miContexto;
        } else {
            throw new RuntimeException(miContexto.toString()
                    + " must implement InterfazComunicadora");
        }
    }
    @Override
    public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {
        List<Persona> miLista=response.body();
        Toast.makeText(this.miContexto,miLista.get(0).toString(),Toast.LENGTH_LONG).show();
        Persona[] miArrayPersona=new Persona[miLista.size()];
        miLista.toArray(miArrayPersona);
        enviador.cuandoAcabe(miArrayPersona);
    }

    @Override
    public void onFailure(Call<List<Persona>> call, Throwable t) {
        Toast.makeText(miContexto,"Argo ha fallao picha",Toast.LENGTH_SHORT);
    }
}
