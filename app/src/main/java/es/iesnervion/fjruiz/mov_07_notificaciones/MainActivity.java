package es.iesnervion.fjruiz.mov_07_notificaciones;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import es.iesnervion.fjruiz.mov_07_notificaciones.Model.Persona;
import es.iesnervion.fjruiz.mov_07_notificaciones.clienteApi.InterfazComunicadora;
import es.iesnervion.fjruiz.mov_07_notificaciones.clienteApi.InterfazComunicadora2;
import es.iesnervion.fjruiz.mov_07_notificaciones.clienteApi.MiclienteApi;
import es.iesnervion.fjruiz.mov_07_notificaciones.notificacion.*;
import es.iesnervion.fjruiz.mov_07_notificaciones.permisos.Permiso;

//TODO Usar api rest que haga para el ejemplo de las contraseñas (SYP-07-Seguridad)

//TODO Mirar como puedo mostrar la notificación estando en primer plano la aplicación

public class MainActivity extends AppCompatActivity implements InterfazComunicadora2,InterfazComunicadora {

    boolean tengoInternet=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this, FirebaseNotification.class));
        startService(new Intent(this, GetToken.class));

        Permiso miPermiso=new Permiso(this);
        miPermiso.getInternet(0);
        //region Autonotificación

        /*NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this);



        mBuilder.setContentTitle("My notification");
        mBuilder.setContentText("Hello World!");
        mBuilder.setSmallIcon(R.drawable.ic_lightbulb_outline_white_24dp);
        mBuilder.setAutoCancel(true);
        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, ResultActivity.class);

        // The stack builder object will contain an artificial back stack for the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(ResultActivity.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // mId allows you to update the notification later on.
        int mId=0;
        mNotificationManager.notify(mId, mBuilder.build());*/

        //endregion

        MiclienteApi miCliente=new MiclienteApi(this);
        miCliente.getPersonas();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        // If request is cancelled, the result arrays are empty.
        if (grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            tengoInternet=true;
        } else {
            tengoInternet=false;
        }
    }

    public void cuandoAcabe2(Persona[] miArray){
        Toast.makeText(this,miArray[0].toString(),Toast.LENGTH_LONG).show();
    }

    public void cuandoAcabe(Persona[] miArray){ //Tal vez no necesario

    }
}
