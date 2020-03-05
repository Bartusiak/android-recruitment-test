package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.repository.model.RawAlbum
import retrofit2.Call
import retrofit2.http.GET

interface AlbumService {

    @GET("albums")
    fun fetchAllAlbums(): Call<List<RawAlbum>>

}