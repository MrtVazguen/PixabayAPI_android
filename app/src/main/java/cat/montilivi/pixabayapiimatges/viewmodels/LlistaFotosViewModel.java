package cat.montilivi.pixabayapiimatges.viewmodels;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

import cat.montilivi.pixabayapiimatges.activities.MainActivity;
import cat.montilivi.pixabayapiimatges.adaptadors.LlistarFotosAdapter;
import cat.montilivi.pixabayapiimatges.databinding.LlistaFotosFragmentBinding;
import cat.montilivi.pixabayapiimatges.models.Foto;
import cat.montilivi.pixabayapiimatges.models.FotoResposta;
import cat.montilivi.pixabayapiimatges.xarxa.PixaBayApiAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LlistaFotosViewModel extends ViewModel {

    MutableLiveData<String> _resposta = new MutableLiveData<>();
    public LiveData<String> resposta = _resposta;

    private  String temaQuery="";

    MutableLiveData<List<Foto>> _fotos = new MutableLiveData<>();
    public LiveData<List<Foto>> fotos = _fotos;

    RecyclerView recyclerView;
    LlistarFotosAdapter mAdapter;



    public void getResposta ()//https://pixabay.com/api/?key=20188833-50affd20a8930d361bfc73f74&q=spain&image_type=photo
    {

         String[] cerca = MainActivity.cerca;
         int size = cerca.length-1;
         int[] array = new Random().ints(1, 0, size*7).toArray();
        temaQuery =  cerca[ (array[0])%size];




        PixaBayApiAdapter.obteApiService().getPhotosPixaBay(
                MainActivity.API_KEY,
                temaQuery , "photo"
        )
        /*
        PixaBayApiAdapter.obteApiService().getImageResults(
                MainActivity.API_KEY,
                "spain",
                1,
                10
        )*/.enqueue(new Callback<FotoResposta>() {
            @Override
            public void onResponse(Call<FotoResposta> call,
                                   Response<FotoResposta> response) {

                if(response.isSuccessful()) {
                    Log.e("",String.valueOf(response.code()));
                    _fotos.setValue(response.body().getPhotos());
                    _resposta.setValue(String.valueOf(fotos.getValue().size()));
                }
                else
                {
                    _resposta.setValue("Code: "+String.valueOf(response.code()+" Hi ha hagut un error al parsejar la resposta: " + response.errorBody()));
                }
            }

            @Override
            public void onFailure(Call<FotoResposta> call, Throwable t) {
                _resposta.setValue("Hi ha hagut un error al connectar amb l'API de la PixaBay: " + t.getMessage());
            }
        });



        ///region onclick picutres


        ///endregion
    }


   public  boolean GenerarRecylerView(List<Foto> fotos, LlistaFotosFragmentBinding binding, Context context, View view)
   {
       boolean fet =true;
       if(fotos!=null&& context!=null& fotos.size()>0) {

           String[] urlFotos = new String[fotos.size()];
           String[] tagsFotos = new String[fotos.size()];
           for (int i = 0; i < fotos.size(); i++) {
               urlFotos[i] = fotos.get(i).getWebformatURL();
               tagsFotos[i] = fotos.get(i).getTags();
           }
            /*
           String url = urlFotos[0];
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

           //misatge tag
           //binding.tvMesatge.setText(tagsFotos[0]);


           ///region recylerview
           recyclerView = binding.recyclerviewFotos;
           RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context.getApplicationContext(), 2);
           mAdapter = new LlistarFotosAdapter(context.getApplicationContext(), urlFotos,view);
           recyclerView.setLayoutManager(layoutManager);
           recyclerView.setItemAnimator(new DefaultItemAnimator());
           recyclerView.setAdapter(mAdapter);

           binding.tvMesatge.setText("Galerias : "+temaQuery);


           ///endregion
       }
       else return fet=false;
       return fet;
   }


}