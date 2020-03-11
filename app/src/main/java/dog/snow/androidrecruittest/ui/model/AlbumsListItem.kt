package dog.snow.androidrecruittest.ui.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "albums_list_item")
data class AlbumsListItem (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "album_id")
    val id: Int,
    @ColumnInfo(name = "user_id")
    val userId: Int,
    @ColumnInfo(name = "album_title")
    val title: String
)