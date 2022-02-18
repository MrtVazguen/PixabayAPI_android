package cat.montilivi.pixabayapiimatges.xarxa;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/*
   @autor : Vazgen Martirosyan
*/

public class InternetCheck {
    public static boolean isInternetAvailable(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
}
