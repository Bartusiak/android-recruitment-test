package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.ui.model.AlbumsListItem
import dog.snow.androidrecruittest.ui.model.PhotosListItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    @GET("albums")
    fun getAllAlbums(@Query("id")id:PhotosListItem): Call<List<AlbumsListItem>>

}