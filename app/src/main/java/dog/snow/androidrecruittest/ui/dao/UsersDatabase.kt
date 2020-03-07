package dog.snow.androidrecruittest.ui.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import dog.snow.androidrecruittest.ui.model.UsersListItem

@Database(entities = [(UsersListItem::class)],version = 1)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao
}