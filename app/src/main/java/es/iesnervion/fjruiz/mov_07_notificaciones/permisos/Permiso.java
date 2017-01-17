package es.iesnervion.fjruiz.mov_07_notificaciones.permisos;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Clase que pide permisos
 */
public class Permiso {
    private Activity miActividad;
    public Permiso(Activity thisActivity){

        miActividad=thisActivity;

    }

    public void getInternet(int requestCode){
        if (ContextCompat.checkSelfPermission(miActividad,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {


            ActivityCompat.requestPermissions(miActividad,
                    new String[]{Manifest.permission.INTERNET},
                    requestCode);
        }
    }
}
