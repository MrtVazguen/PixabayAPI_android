package cat.montilivi.pixabayapiimatges.adaptadors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import cat.montilivi.pixabayapiimatges.R;
import cat.montilivi.pixabayapiimatges.altres.FotosSelectionada;
import cat.montilivi.pixabayapiimatges.fragments.LlistaFotosFragment;
import cat.montilivi.pixabayapiimatges.fragments.LlistaFotosFragmentDirections;
import cat.montilivi.pixabayapiimatges.fragments.TitolFragmentDirections;

public class LlistarFotosAdapter extends RecyclerView.Adapter<LlistarFotosAdapter.LlistarFotosViewHolder>  {

    private  String[]urlFotos;
    private  String[]urlTags;
    private  Context context;
View v ;


    public  LlistarFotosAdapter(Context _context, String[] _urlFotos, View view){
        this.urlFotos=_urlFotos;
        this.context=_context;
        v = view;
    }

    @NonNull
    @Override
    public LlistarFotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new LlistarFotosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LlistarFotosViewHolder holder, int position) {

        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.logodos)
                .error(R.drawable.errorgaleri)
                .fitCenter();//si desconoce el tipo salta exception
        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(urlFotos[position])
                .into(holder.imgIcon);


        ///Position item clicked
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Position : "+position +" Tags: "+urlFotos[position],Toast.LENGTH_LONG).show();
                NavController navController = Navigation.findNavController(v);
                navController.navigate(LlistaFotosFragmentDirections.actionLlistaFotosFragmentToMostrarFotoFragment(urlFotos[position]));
               // navController.navigate(OraclePreguntaFragmentDirections.actionOraclePreguntaFragmentToOracleRespostaFragment(binding.etPregunta.getText().toString().trim()));

                //LlistaFotosFragment fragment=new LlistaFotosFragment();
               // fragment.MostrarFoto(urlFotos[position],urlTags[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return urlFotos.length;
    }



    public  class LlistarFotosViewHolder extends  RecyclerView.ViewHolder {
        ImageView imgIcon;
        TextView title;
        public LlistarFotosViewHolder(@NonNull View itemView) {
            super(itemView);
            imgIcon= itemView.findViewById(R.id.item_image);
            title = itemView.findViewById(R.id.tvMesatge);
        }
    };

}
