package dog.snow.androidrecruittest.ui.model

import androidx.room.Entity

@Entity(tableName = "raw_address")
data class RawAddress(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: RawGeo
)