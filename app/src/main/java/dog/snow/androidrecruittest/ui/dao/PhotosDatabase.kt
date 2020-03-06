package dog.snow.androidrecruittest.ui.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import dog.snow.androidrecruittest.ui.model.PhotosListItem

@Database(entities = [(PhotosListItem::class)],version = 1)
abstract class PhotosDatabase: RoomDatabase() {

    abstract fun photosDao() : PhotosDao
}