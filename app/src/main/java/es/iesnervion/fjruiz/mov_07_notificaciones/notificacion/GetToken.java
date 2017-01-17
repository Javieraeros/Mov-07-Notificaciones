package es.iesnervion.fjruiz.mov_07_notificaciones.notificacion;


import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class GetToken extends FirebaseInstanceIdService {
    private static final String TAG = "Etiqueta";

    @Override
    public void onCreate(){
        onTokenRefresh();
    }

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        System.out.println(refreshedToken+" holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String refreshedToken) {
        //TODO Llamada a la api para registrar el FCM del teléfono si no existe,
        //o actualizar la tabla correspondiente
    }

}
