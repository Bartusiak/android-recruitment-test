package dog.snow.androidrecruittest.ui.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Keep
@Entity(tableName = "photos_list_item")
data class PhotosListItem (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "photo_id")
    var id: Int,
    @ColumnInfo(name = "photo_title")
    var title: String,
    @ColumnInfo(name = "album_title")
    var albumTitle: String,
    @ColumnInfo(name = "url")
    var url: String,
    @ColumnInfo(name = "thumbnail_url")
    var thumbnailUrl: String

)