package dog.snow.androidrecruittest.ui.model

import androidx.room.Entity
import androidx.room.TypeConverter

@Entity(tableName = "raw_geo")
data class RawGeo(
    @TypeConverter
    val lat: String,
    val lng: String
)