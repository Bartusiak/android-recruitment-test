package dog.snow.androidrecruittest.ui.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import dog.snow.androidrecruittest.ui.model.AlbumsListItem

@Database(entities = [(AlbumsListItem::class)],version = 1)
abstract class AlbumsDatabase : RoomDatabase() {
    abstract fun albumsDao(): AlbumsDao
}