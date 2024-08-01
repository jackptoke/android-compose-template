package dev.toke.dispatch3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "printers")
data class Printer(
    @PrimaryKey
    var id: Int=0,
    @ColumnInfo(name = "printer_name")
    var name: String="",
    @ColumnInfo(name = "printer_ip_address")
    var ip: String="",
    @ColumnInfo(name = "is_default")
    var default: Boolean=false
){

}
