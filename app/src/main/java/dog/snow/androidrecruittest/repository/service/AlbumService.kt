package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.ui.model.AlbumsListItem
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface AlbumService {

    @GET("albums")
    //fun getAllAlbums(@Query("id")id:PhotosListItem): Call<List<AlbumsListItem>>
    fun getAllAlbums(): Observable<List<AlbumsListItem>>
}