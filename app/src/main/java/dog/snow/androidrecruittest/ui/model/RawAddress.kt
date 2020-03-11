package dog.snow.androidrecruittest.ui.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity

@Keep
@Entity(tableName = "raw_address")
data class RawAddress(
    @ColumnInfo(name = "street")
    val street: String,
    @ColumnInfo(name = "suite")
    val suite: String,
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "zipcode")
    val zipcode: String,
    @Embedded
    @ColumnInfo(name = "geo")
    val geo: RawGeo
)