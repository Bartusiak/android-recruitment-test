package dog.snow.androidrecruittest.ui.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dog.snow.androidrecruittest.ui.model.UsersListItem
import io.reactivex.Flowable


@Dao
interface UsersDao {
    @Query("SELECT * FROM users_list_item ")
    fun getAllUsers(): Flowable<List<UsersListItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(userList: List<UsersListItem>)

    @Query("DELETE FROM users_list_item")
    fun deleteAllPhotos()
}