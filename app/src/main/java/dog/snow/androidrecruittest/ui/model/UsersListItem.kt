package dog.snow.androidrecruittest.ui.model

import androidx.annotation.Keep
import androidx.room.*

@Keep
@Entity(tableName = "users_list_item")
data class UsersListItem (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "user_id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "user_email")
    val email: String,
    @Embedded
    val address: RawAddress,
    @ColumnInfo(name = "user_phone")
    val phone: String,
    @ColumnInfo(name = "website")
    val website: String,
    @Embedded
    val company: RawCompany
)