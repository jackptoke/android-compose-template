package dev.toke.dispatch3.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import dev.toke.dispatch3.model.Printer
import kotlinx.coroutines.flow.Flow

@Dao
interface PrinterDatabaseDao {
    @Query(value = "SELECT * FROM printers")
    fun getPrinters(): Flow<List<Printer>>

    @Query(value = "SELECT * FROM printers WHERE id = :id")
    suspend fun getPrinter(id: Int): Printer

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(printer: Printer)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(printer: Printer)

    @Query(value = "DELETE FROM printers")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(printer: Printer)
}
