package dog.snow.androidrecruittest.ui.model

import androidx.room.Entity

@Entity(tableName = "raw_company")
data class RawCompany (
    val name: String,
    val catchPhrase: String,
    val bs: String
)