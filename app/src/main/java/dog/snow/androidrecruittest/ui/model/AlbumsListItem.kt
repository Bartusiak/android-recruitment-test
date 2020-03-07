package dog.snow.androidrecruittest.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albums_list_item")
data class AlbumsListItem (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val userId: Int,
    val title: String
)