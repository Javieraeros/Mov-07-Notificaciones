package es.iesnervion.fjruiz.mov_07_notificaciones.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fjruiz on 31/01/17.
 */

public class JaviDB extends SQLiteOpenHelper {
    private static String DB_NAME="Mi_DB";
    private static int VERSION=1;

    public JaviDB(Context context) {
        super(context, DB_NAME, null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String creaTabla="Create table "+Contrato.Persona.TABLA+"(";
        creaTabla+=Contrato.Persona.ID+" integer primary key autoincrement,";
        creaTabla+=Contrato.Persona.NOMBRE+" text,";
        creaTabla+=Contrato.Persona.APELLIDOS+" text,";
        creaTabla+=Contrato.Persona.FOTO+" blob);";
        db.execSQL(creaTabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    @Override
    public void onDowngrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}
