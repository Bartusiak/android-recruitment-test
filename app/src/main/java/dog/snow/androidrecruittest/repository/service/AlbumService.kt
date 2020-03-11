package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.ui.model.AlbumsListItem
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    @GET("albums")
    //fun getAllAlbums(@Query("id")id:PhotosListItem): Call<List<AlbumsListItem>>
    fun getAllAlbums(@Query("limit") limit:Int=100): Observable<List<AlbumsListItem>>
}