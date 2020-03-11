package dog.snow.androidrecruittest.ui.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import org.jetbrains.annotations.NotNull

@Keep
@Entity(tableName = "raw_company")
data class RawCompany (
    @NotNull
    @ColumnInfo(name = "name_company")
    val name: String,
    @ColumnInfo(name = "phrase")
    val catchPhrase: String,
    @ColumnInfo(name = "bs")
    val bs: String
)