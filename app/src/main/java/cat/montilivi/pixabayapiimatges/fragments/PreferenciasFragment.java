package cat.montilivi.pixabayapiimatges.fragments;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import cat.montilivi.pixabayapiimatges.R;

public class PreferenciasFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferencies, rootKey);
    }
}
