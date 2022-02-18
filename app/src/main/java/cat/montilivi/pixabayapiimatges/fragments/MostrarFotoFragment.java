package cat.montilivi.pixabayapiimatges.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import cat.montilivi.pixabayapiimatges.R;
import cat.montilivi.pixabayapiimatges.databinding.FragmentMostrarFotoBinding;
import cat.montilivi.pixabayapiimatges.databinding.FragmentMostrarFotoBindingImpl;

public class MostrarFotoFragment extends Fragment {
FragmentMostrarFotoBinding binding;

    public MostrarFotoFragment() {
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
       // return inflater.inflate(R.layout.fragment_mostrar_foto, container, false);
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_mostrar_foto,container,false);

        String urlFoto = MostrarFotoFragmentArgs.fromBundle(getArguments()).getUrlFoto();
        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.logodos)
                .error(R.drawable.errorgaleri)
                .fitCenter();//si desconoce el tipo salta exception

        Glide.with(this)
                .load(urlFoto)
                .into(binding.ivFoto);

        return  binding.getRoot();
    }
}