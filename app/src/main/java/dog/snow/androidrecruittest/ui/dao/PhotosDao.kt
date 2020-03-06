package dog.snow.androidrecruittest.ui.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dog.snow.androidrecruittest.ui.model.PhotosListItem

@Dao
interface PhotosDao {

    @Query("SELECT * FROM photos_list_item ")
    fun getAllPhotos():LiveData<List<PhotosListItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPhotos(photosList: List<PhotosListItem>)

    @Query("DELETE FROM photos_list_item")
    fun deleteAllPhotos()
}