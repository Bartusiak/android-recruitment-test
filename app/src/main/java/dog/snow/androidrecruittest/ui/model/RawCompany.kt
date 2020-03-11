package dog.snow.androidrecruittest.ui.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity

@Keep
@Entity(tableName = "raw_company")
data class RawCompany (
    @ColumnInfo(name = "name_company")
    val nameCompany: String,
    @ColumnInfo(name = "phrase")
    val catchPhrase: String,
    @ColumnInfo(name = "bs")
    val bs: String
)