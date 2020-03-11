package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.repository.model.RawPhoto
import dog.snow.androidrecruittest.ui.model.PhotosListItem
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoService {

    @GET("photos")
    fun getAllPhotos(@Query("limit") limit:Int=100): Observable<List<PhotosListItem>>


}