package dev.toke.dispatch3.repository

import dev.toke.dispatch3.data.PrinterDatabaseDao
import dev.toke.dispatch3.model.Printer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PrinterRepository @Inject constructor(private val printerDatabaseDao: PrinterDatabaseDao) {
    suspend fun addPrinter(printer: Printer) = printerDatabaseDao.insert(printer)
    suspend fun getPrinter(id: Int) = printerDatabaseDao.getPrinter(id)
    suspend fun updatePrinter(printer: Printer) = printerDatabaseDao.update(printer)
    suspend fun deletePrinter(printer: Printer) = printerDatabaseDao.delete(printer)
    suspend fun deleteAllPrinters() = printerDatabaseDao.deleteAll()

    fun getPrinters(): Flow<List<Printer>> = printerDatabaseDao
        .getPrinters()
        .flowOn(Dispatchers.IO)
        .conflate()
}