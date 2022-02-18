package cat.montilivi.pixabayapiimatges.fragments;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cat.montilivi.pixabayapiimatges.R;
import cat.montilivi.pixabayapiimatges.altres.FotosSelectionada;
import cat.montilivi.pixabayapiimatges.databinding.LlistaFotosFragmentBinding;
import cat.montilivi.pixabayapiimatges.models.Foto;
import cat.montilivi.pixabayapiimatges.viewmodels.LlistaFotosViewModel;
import cat.montilivi.pixabayapiimatges.xarxa.InternetCheck;

public class LlistaFotosFragment extends Fragment  {

    ///region recyclerview
   private RecyclerView recyclerView;
    private  RecyclerView.Adapter adapter;
    private View listItems;
    private  RecyclerView.LayoutManager layoutManager;
    ///endregion

    private LlistaFotosViewModel mViewModel;
    LlistaFotosFragmentBinding binding;

    public static LlistaFotosFragment newInstance() {
        return new LlistaFotosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {


        ///region codi Normal Sense recylerview mostrant nomes un imatge

        ///region antes
        binding = DataBindingUtil.inflate(inflater, R.layout.llista_fotos_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(LlistaFotosViewModel.class);
        binding.setViewModel(mViewModel);
        binding.executePendingBindings();
        binding.setLifecycleOwner(this);
        ///endregion

        if (InternetCheck.isInternetAvailable(getContext()) == true) {
            //return inflater.inflate(R.layout.llista_fotos_fragment, container, false);
           //agafem els valors de LlistaFotosViewModel,   MutableLiveData<List<Foto>> _fotos = new MutableLiveData<>();
            mViewModel.fotos.observe(binding.getLifecycleOwner(), new Observer<List<Foto>>() {
                @Override
                public void onChanged(List<Foto> fotos) {
                    //generem en LlistaFotosViewModel las RecylerView
                   if(! mViewModel.GenerarRecylerView(  fotos,binding,getContext(),requireView()))
                   {
                       binding.tvMesatge.setText("No hem pogut generar recylerview");
                   }



                    ///region Codi No activa : URl pasar Imatge usant Glide
                    /*
              String url = fotos.get(0).getWebformatURL();
               //String url = "https://pixabay.com/get/g60e341d1199edfba4f091ba930879daf02f2ed152e7856954ee2823e57f045e9062a8be2e4d87c96796b26092b60399e6f3d8143d086b8677d8fca516705e544_640.jpg";
                binding.tvMesatge.setText(fotos.get(0).getTags());
                    Uri imgUri = Uri
                                    .parse(url)
                                    .buildUpon()
                                    .scheme("https")
                                    .build();

                            Glide.with(binding.ivFoto.getContext())
                                    .load(imgUri)
                                    .apply(new RequestOptions())
                                    .placeholder(android.R.drawable.ic_menu_search)
                                    .error(android.R.drawable.ic_dialog_alert)
                                    .into(binding.ivFoto);
                            */
                            ///endregion

                }
            });
           
            mViewModel.getResposta();

        } else
            {    //codi Normal
               binding.tvMesatge.setText("No hi ha coneccio !!!");
             }
             //codi normal


            return binding.getRoot();


    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LlistaFotosViewModel.class);
        // TODO: Use the ViewModel
    }





/*
    private   void MostrarFotosNavController(String webformatURL,String tags){
      NavController navController = Navigation.findNavController(getActivity(), R.id.frgNavHostFragment);
       // navController.navigate(R.id.action_llistaFotosFragment_to_mostrarFotoFragment);
       // navController.navigate(LlistaFotosFragmentDirections.actionLlistaFotosFragmentToResultatFragment());

        Foto foto = new Foto();
        foto.setWebformatURL(webformatURL);
        foto.setTags(tags);


        //pasem els dades de foto
        navController.navigate(LlistaFotosFragmentDirections.actionLlistaFotosFragmentToMostrarFotoFragment(foto));
    }

*/

}