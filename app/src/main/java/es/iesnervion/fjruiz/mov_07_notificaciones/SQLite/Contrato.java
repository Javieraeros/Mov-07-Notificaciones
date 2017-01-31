package es.iesnervion.fjruiz.mov_07_notificaciones.SQLite;

import android.provider.BaseColumns;

/**
 * Created by fjruiz on 31/01/17.
 */

public class Contrato {
    public static class Persona implements BaseColumns{

        public final static String TABLA="Personas";
        public final static String ID="_Id";
        public final static String NOMBRE="Nombre";
        public final static String APELLIDOS="Apellidos";
        public final static String FOTO="Foto";
    }
}
