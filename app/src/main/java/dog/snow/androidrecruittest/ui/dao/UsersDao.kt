package dog.snow.androidrecruittest.ui.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dog.snow.androidrecruittest.ui.model.UsersListItem

@Dao
interface UsersDao {
    @Query("SELECT * FROM users_list_item ")
    fun getAllUsers(): LiveData<List<UsersListItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(photosList: List<UsersListItem>)

    @Query("DELETE FROM users_list_item")
    fun deleteAllPhotos()
}