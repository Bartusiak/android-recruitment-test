package dog.snow.androidrecruittest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import dog.snow.androidrecruittest.ui.ListFragment
import dog.snow.androidrecruittest.ui.dao.PhotosDatabase

internal lateinit var recyclerView: RecyclerView

class MainActivity : AppCompatActivity(R.layout.main_activity){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.toolbar))

        var fragment : ListFragment = ListFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.rv_items,fragment)
            commit()
        }
        /*var fragmentManager: FragmentManager
        var fragmentTransaction: FragmentTransaction
        fragmentTransaction = fragmentManager.beginTransaction().apply {  }*/

//        recyclerView.setHasFixedSize(true)
 //       recyclerView.layoutManager = LinearLayoutManager(this)


    }
}