package dog.snow.androidrecruittest

import android.content.Context
import androidx.room.Room
import dog.snow.androidrecruittest.repository.service.AlbumService
import dog.snow.androidrecruittest.repository.service.PhotoService
import dog.snow.androidrecruittest.repository.service.UserService
import dog.snow.androidrecruittest.ui.dao.AlbumsDatabase
import dog.snow.androidrecruittest.ui.dao.PhotosDatabase
import dog.snow.androidrecruittest.ui.dao.UsersDatabase
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object LoadRetrofitAndRoom {

    var database_photos: PhotosDatabase?=null
    var database_albums: AlbumsDatabase?=null
    var database_users: UsersDatabase?=null

    val okHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply{
        level= HttpLoggingInterceptor.Level.BODY
    }).build()

    public fun getInstancePhotos(context: Context): PhotosDatabase?{
        if(database_photos==null){
            database_photos= Room.databaseBuilder(context,PhotosDatabase::class.java,"photo")
                .fallbackToDestructiveMigration()
                .build()
        }
        return database_photos
    }

    public fun getInstanceAlbums(context: Context): AlbumsDatabase?{
        if(database_albums==null){
            database_albums=Room.databaseBuilder(context,AlbumsDatabase::class.java,"albums")
                .fallbackToDestructiveMigration()
                .build()
        }
        return database_albums
    }

    public fun getInstanceUsers(context: Context): UsersDatabase?{
        if(database_users==null){
            database_users=Room.databaseBuilder(context,UsersDatabase::class.java,"users")
                .fallbackToDestructiveMigration()
                .build()
        }
        return database_users
    }

    val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .client(okHttpClient)
        .build()

    val apiphotos = retrofit.create(PhotoService::class.java)
    val apialbums = retrofit.create(AlbumService::class.java)
    val apiusers = retrofit.create(UserService::class.java)


}