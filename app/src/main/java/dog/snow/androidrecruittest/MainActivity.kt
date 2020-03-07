package dog.snow.androidrecruittest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import dog.snow.androidrecruittest.ui.dao.PhotosDatabase

class MainActivity : AppCompatActivity(R.layout.main_activity){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.toolbar))


    }
}