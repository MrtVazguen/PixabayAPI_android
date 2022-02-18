package cat.montilivi.pixabayapiimatges.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import cat.montilivi.pixabayapiimatges.R;
import cat.montilivi.pixabayapiimatges.databinding.FragmentTitolBinding;


public class TitolFragment extends Fragment {

    FragmentTitolBinding binding;
    NavController navController;

    public TitolFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_titol, container, false);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_titol, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.frgNavHostFragment);



        //preferencias
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        if(! preferences.getBoolean("swTemariAliatori",false)){
            binding.tvCercaUrl.setVisibility(View.VISIBLE);

        }
        else {  binding.tvCercaUrl.setVisibility(View.INVISIBLE); }

        ///region Action bar
        //AppCompatActivity activity = (AppCompatActivity) getActivity();
        //if (getActionBar() != null ) {
         //   this.getSupportActionBar().show();
        // activity.getSupportActionBar().setTitle("Pixabay");
        //  activity.getSupportActionBar().setSubtitle("Album de fotos");
        //}
        ///endregion

        //para el menu
        setHasOptionsMenu(true);

        binding.btnPixabay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              navController.navigate(R.id.action_titolFragment_to_llistaFotosFragment);
 

            }
        });
        return binding.getRoot();
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.mnuprincipal, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item) || NavigationUI.onNavDestinationSelected(item, navController);

    }
}