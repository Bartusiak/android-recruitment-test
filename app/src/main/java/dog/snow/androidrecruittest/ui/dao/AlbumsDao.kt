package dog.snow.androidrecruittest.ui.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dog.snow.androidrecruittest.ui.model.AlbumsListItem
import io.reactivex.Flowable

@Dao
interface AlbumsDao {

    @Query("SELECT * FROM albums_list_item")
    fun getAllAlbums(): Flowable<List<AlbumsListItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAlbums(albumsList: List<AlbumsListItem>)

    @Query("DELETE FROM albums_list_item")
    fun deleteAllAlbums()

}