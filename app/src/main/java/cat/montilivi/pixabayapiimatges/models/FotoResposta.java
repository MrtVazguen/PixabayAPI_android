package cat.montilivi.pixabayapiimatges.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FotoResposta {
    @SerializedName("hits")
    List<Foto> photos;

    public List<Foto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Foto> photos) {
        this.photos = photos;
    }
}
