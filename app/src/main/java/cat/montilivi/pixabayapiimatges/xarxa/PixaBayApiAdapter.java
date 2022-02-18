package cat.montilivi.pixabayapiimatges.xarxa;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PixaBayApiAdapter {
    //https://pixabay.com/api/?key=20188833-50affd20a8930d361bfc73f74&q=armenia&image_type=photo
    private  static  PixaBayApiService  API_SERVICE;
    static String BASE_URL = "https://pixabay.com/";



    public  static  PixaBayApiService  obteApiService ()
    {
        if (API_SERVICE == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit =
                    new Retrofit.Builder()
                            //.addConverterFactory(ScalarsConverterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .baseUrl(BASE_URL)
                            .build();
            API_SERVICE = retrofit.create(PixaBayApiService.class);
        }
        return API_SERVICE;
    }
}
