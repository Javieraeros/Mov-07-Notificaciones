package es.iesnervion.fjruiz.mov_07_notificaciones.clienteApi;

import java.util.List;

import es.iesnervion.fjruiz.mov_07_notificaciones.Model.Persona;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestInterface {
    @GET("personas")
    Call<List<Persona>> getPersonas();
}
