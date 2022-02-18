package cat.montilivi.pixabayapiimatges.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;

import cat.montilivi.pixabayapiimatges.R;
import cat.montilivi.pixabayapiimatges.databinding.ActivityMainBinding;



/*
* @autor: Vazguen,  curso 2020-2021
*/
public class MainActivity extends AppCompatActivity {

    public static String[] cerca ={};
    public static String API_KEY = "20188833-50affd20a8930d361bfc73f74";

    NavController navController;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       // setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//no gira pantalla

        //inflamos binding i navController
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        navController = Navigation.findNavController(this,R.id.frgNavHostFragment);

        ///region Action bar titles
        getSupportActionBar().setTitle("Pixabay");
        getSupportActionBar().setSubtitle("Fotos digitals");
        ///endregion

        ///query de galeria: random
        Resources res = getResources();
        cerca= res.getStringArray(R.array.budueda_paraules_array);

        //navigation drawable
        NavigationUI.setupActionBarWithNavController(this,navController,binding.drawerLayut);
        NavigationUI.setupWithNavController(binding.navView,navController);//click

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                                             @NonNull NavDestination destination,
                                             @Nullable Bundle arguments) {
                if(destination.getId()==navController.getGraph().getStartDestination()|| destination.getId()==R.id.titolFragment) //destinacion de deplegament
                {
                    binding.drawerLayut.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                }
                else{
                    binding.drawerLayut.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                }
            }
        });
    }
}