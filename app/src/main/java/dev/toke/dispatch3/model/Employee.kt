package dev.toke.dispatch3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employees")
data class Employee(
    @PrimaryKey
    var id: Int,
    @ColumnInfo(name = "username")
    var username: String,
    @ColumnInfo(name = "first_name")
    var firstName: String,
    @ColumnInfo(name = "last_name")
    var lastName: String,
    @ColumnInfo(name = "is_active")
    var active: Boolean,
    @ColumnInfo(name = "role")
    var roles: String,
//    @ColumnInfo(name = "auth_expiry_date")
//    val authExpiryDate: LocalDateTime
) {

}
