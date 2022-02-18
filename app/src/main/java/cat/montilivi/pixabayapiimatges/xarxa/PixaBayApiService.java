package cat.montilivi.pixabayapiimatges.xarxa;

import com.bumptech.glide.load.ImageHeaderParser;

import cat.montilivi.pixabayapiimatges.altres.PixabayImageType;
import cat.montilivi.pixabayapiimatges.models.FotoResposta;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//https://pixabay.com/api/?key=20188833-50affd20a8930d361bfc73f74&q=armenia&page=1&image_type=photo
public interface PixaBayApiService {
        @GET("/api/")
        Call<FotoResposta> getPhotosPixaBay(
                @Query("key")String clau,
                @Query("q")String q,
                @Query("image_type") String imageType
        );
        @GET("/api/")
        Call<FotoResposta> getImageResults
                (@Query("key") String key, @Query("q") String query, @Query("page") int page, @Query("per_page") int perPage);
}
