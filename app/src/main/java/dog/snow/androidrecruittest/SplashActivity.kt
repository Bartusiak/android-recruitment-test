package dog.snow.androidrecruittest

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.os.Handler
import android.provider.ContactsContract
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dog.snow.androidrecruittest.repository.service.AlbumService
import dog.snow.androidrecruittest.repository.service.PhotoService
import dog.snow.androidrecruittest.repository.service.UserService
import dog.snow.androidrecruittest.ui.dao.AlbumsDatabase
import dog.snow.androidrecruittest.ui.dao.PhotosDatabase
import dog.snow.androidrecruittest.ui.dao.UsersDatabase
import dog.snow.androidrecruittest.ui.model.AlbumsListItem
import dog.snow.androidrecruittest.ui.model.PhotosListItem
import dog.snow.androidrecruittest.ui.model.UsersListItem
import io.reactivex.CompletableObserver
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.internal.util.HalfSerializer.onError
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.layout_banner.view.*
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.concurrent.thread

class SplashActivity : AppCompatActivity(R.layout.splash_activity){
    private val SPLASH_TIME_OUT = 1000;
    private var photosIsComplete: Boolean? = false
    private var albumsIsComplete: Boolean? = false
    private var usersIsComplete: Boolean? = false


    val okHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply{
        level=HttpLoggingInterceptor.Level.BODY
    }).build()



    private fun showError(errorMessage: String?) {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.cant_download_dialog_title)
            .setMessage(getString(R.string.cant_download_dialog_message, errorMessage))
            .setPositiveButton(R.string.cant_download_dialog_btn_positive) { _, _ -> loadDataFromWeb() }
            .setNegativeButton(R.string.cant_download_dialog_btn_negative) { _, _ -> finish() }
            .create()
            .apply { setCanceledOnTouchOutside(false) }
            .show()
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState);


        loadDataFromWeb()

        Handler().postDelayed(object:Runnable{
            public override fun run(){
                checkApisComplete()
            }
        },SPLASH_TIME_OUT.toLong())

    }

    private fun checkApisComplete(){
        Log.d("DEBUG_CheckApi","photo: "+photosIsComplete+" albums: "+ albumsIsComplete + " users: "+usersIsComplete)
        if(photosIsComplete==true && albumsIsComplete==true && usersIsComplete==true ){
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun loadDataFromWeb(){
        var database_photos= Room
            .databaseBuilder(applicationContext, PhotosDatabase::class.java, "photos")
            .build()

        var database_albums = Room
            .databaseBuilder(applicationContext,AlbumsDatabase::class.java,"albums")
            .build()

        var database_users = Room
            .databaseBuilder(applicationContext,UsersDatabase::class.java,"users")
            .build()

        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(okHttpClient)
            .build()

        val apiphotos = retrofit.create(PhotoService::class.java)
        val apialbums = retrofit.create(AlbumService::class.java)
        val apiusers = retrofit.create(UserService::class.java)

        apiphotos.getAllPhotos().doOnNext{database_photos.photosDao().insertAllPhotos(it)}.observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onError = {
                showError("ApiPhotos: " + it.message);
                Log.d("DEBUG_API_PHOTO: ", it.message)
            },onComplete = {
                photosIsComplete=true
            })

        apialbums.getAllAlbums().doOnNext{database_albums.albumsDao().insertAllAlbums(it)}.observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onError = {
                showError("ApiAlbums: " + it.message)
                Log.d("DEBUG_API_ALBUM: ",  it.message)
            },onComplete = {
                albumsIsComplete=true
            })

        apiusers.getAllUsers().doOnNext{database_users.usersDao().insertAllUsers(it)}.observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onError = {
                showError("ApiUsers: " + it.message)
                Log.d("DEBUG_API_USERS: ",  it.message)
            },onComplete = {
                usersIsComplete=true
            })

        checkApisComplete()



    }

}