package dog.snow.androidrecruittest.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "users_list_item")
data class UsersListItem (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    @TypeConverters(RawAddress::class)
    val address: RawAddress,
    val phone: String,
    val website: String,
    @TypeConverters(RawCompany::class)
    val company: RawCompany
)