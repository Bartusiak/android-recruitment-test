package dog.snow.androidrecruittest.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity(tableName = "photos_list_item")
data class PhotosListItem (
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var title: String,
    var albumTitle: String,
    var url: String,
    var thumbnailUrl: String

)