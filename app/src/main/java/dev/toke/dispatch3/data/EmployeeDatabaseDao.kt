package dev.toke.dispatch3.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import dev.toke.dispatch3.model.Employee
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDatabaseDao {
    @Query(value = "SELECT * FROM employees")
    fun getEmployees(): Flow<List<Employee>>

    @Query(value = "SELECT * FROM employees WHERE id = :id")
    suspend fun getEmployee(id: Int): Employee

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(employee: Employee)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(employee: Employee)

    @Query(value = "DELETE FROM employees")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(employee: Employee)
}