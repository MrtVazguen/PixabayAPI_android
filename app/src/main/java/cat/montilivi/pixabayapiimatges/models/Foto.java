package cat.montilivi.pixabayapiimatges.models;

import com.google.gson.annotations.SerializedName;
import android.text.TextUtils;
import cat.montilivi.pixabayapiimatges.altres.PixabayImageType;

/*
*"         "id": 3063284,
            "pageURL": "https://pixabay.com/photos/rose-flower-petal-floral-noble-3063284/",
            "type": "photo",
            "tags": "rose, flower, petal",
            "previewURL": "https://cdn.pixabay.com/photo/2018/01/05/16/24/rose-3063284_150.jpg",
            "previewWidth": 150,
            "previewHeight": 99,
            "webformatURL": "https://pixabay.com/get/gd973307c87d0cadec68c861d03d61f753331c5a8d3d04ca5ce1b085c4e6c0bb30e7ca48c00011f292760ab0a94eb745527ceb161f9744aa46bf4b96f40e29108_640.jpg",
            "webformatWidth": 640,
            "webformatHeight": 426,
            "largeImageURL": "https://pixabay.com/get/g30d08048c2d69b5ad17a26a4b09cd975390cb2712953f65dfd8f26fe392f5d8ff538529f44c9e04d81ab97b59d17bac4723224bf1e5bc7727ee4ca8ba5c001fd_1280.jpg",
            "imageWidth": 6000,
            "imageHeight": 4000,
            "imageSize": 3574625,
            "views": 837281,
            "downloads": 532742,
            "favorites": 1102,
            "likes": 1267,
            "comments": 284,
            "user_id": 1564471,
            "user": "anncapictures",
            "userImageURL": "https://cdn.pixabay.com/user/2015/11/27/06-58-54-609_250x250.jpg"
        }

* */

public class Foto {
    ///region Atributs
    private int id;
    private String pageURL;
    private String type;
    @SerializedName("tags")
    private String tags;
    private String previewURL;
    private int previewWidth;
    private int previewHeight;
    @SerializedName("webformatURL")
    private String webformatURL;
    private int webformatWidth;
    private int webformatHeight;
    private  String largeImageURL;
    private  int imageWidth;
    private  int imageHeight;
    private  int imageSize;
    private  int views;
    private  int downloads;
    private  int favorites;
    private  int likes;
    private  int comments;
    private  int user_id;
    private  String user;
    private  String userImageURL;
    ///endregion
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public int getPreviewWidth() {
        return previewWidth;
    }

    public void setPreviewWidth(int previewWidth) {
        this.previewWidth = previewWidth;
    }

    public int getPreviewHeight() {
        return previewHeight;
    }

    public void setPreviewHeight(int previewHeight) {
        this.previewHeight = previewHeight;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public int getWebformatWidth() {
        return webformatWidth;
    }

    public void setWebformatWidth(int webformatWidth) {
        this.webformatWidth = webformatWidth;
    }

    public int getWebformatHeight() {
        return webformatHeight;
    }

    public void setWebformatHeight(int webformatHeight) {
        this.webformatHeight = webformatHeight;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getImageSize() {
        return imageSize;
    }

    public void setImageSize(int imageSize) {
        this.imageSize = imageSize;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }






}
