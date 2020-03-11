package dog.snow.androidrecruittest.ui.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.TypeConverter

@Keep
@Entity(tableName = "raw_geo")
data class RawGeo(
    @ColumnInfo(name = "latitude")
    val lat: String,
    @ColumnInfo(name = "longitude")
    val lng: String
)