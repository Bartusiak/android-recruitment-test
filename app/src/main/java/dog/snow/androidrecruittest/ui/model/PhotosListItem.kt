package dog.snow.androidrecruittest.ui.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import org.jetbrains.annotations.NotNull
import java.util.*

@Keep
@Entity(tableName = "photos_list_item")
data class PhotosListItem (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "photo_id")
    var id: Int,
    @ColumnInfo(name = "album_id")
    var albumId: Int,
    @ColumnInfo(name = "photos_title")
    var title: String,
    @ColumnInfo(name = "url")
    var url: String,
    @ColumnInfo(name = "thumbnail_url")
    var thumbnailUrl: String

)