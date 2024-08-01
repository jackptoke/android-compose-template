package dev.toke.dispatch3.repository

import dev.toke.dispatch3.data.EmployeeDatabaseDao
import dev.toke.dispatch3.model.Employee
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class EmployeeRepository @Inject constructor(private val employeeDatabaseDao: EmployeeDatabaseDao) {
    suspend fun addEmployee(employee: Employee) = employeeDatabaseDao.insert(employee)
    suspend fun updateEmployee(employee: Employee) = employeeDatabaseDao.update(employee)
    suspend fun deleteEmployee(employee: Employee) = employeeDatabaseDao.delete(employee)
    suspend fun deleteAllEmployees() = employeeDatabaseDao.deleteAll()
    suspend fun getEmployee(id: Int) = employeeDatabaseDao.getEmployee(id)

    fun getEmployees(): Flow<List<Employee>> = employeeDatabaseDao.getEmployees()
        .flowOn(Dispatchers.IO)
        .conflate()
}