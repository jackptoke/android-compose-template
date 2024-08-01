package dev.toke.dispatch3.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import dev.toke.dispatch3.model.Employee
import dev.toke.dispatch3.model.Printer
import dev.toke.dispatch3.utils.LocalDateTimeConverter

@Database(entities = [Printer::class, Employee::class], version = 1, exportSchema = false)
//@TypeConverters(LocalDateTimeConverter::class)
abstract  class AmeDatabase: RoomDatabase() {
    abstract fun printerDao(): PrinterDatabaseDao
    abstract fun employeeDao(): EmployeeDatabaseDao
}