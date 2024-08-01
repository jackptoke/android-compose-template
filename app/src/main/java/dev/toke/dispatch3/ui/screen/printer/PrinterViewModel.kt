package dev.toke.dispatch3.ui.screen.printer

import android.util.Log
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.toke.dispatch3.model.Printer
import dev.toke.dispatch3.repository.PrinterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrinterViewModel @Inject constructor(private val repository: PrinterRepository): ViewModel() {
    private val _printerList = MutableStateFlow<List<Printer>>(emptyList())
    val printerList = _printerList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPrinters().distinctUntilChanged()
                .collect { printers ->
                    if(printers.isNullOrEmpty()) {
                        Log.d("PrinterViewModel - init", "Empty printer list")
                    }
                    else{
                        _printerList.value = printers
                    }
                }
        }
    }

    fun addPrinter(printer: Printer) = viewModelScope.launch {
        repository.addPrinter(printer)
    }

    fun updatePrinter(printer: Printer) = viewModelScope.launch {
        repository.updatePrinter(printer)
    }

    fun deletePrinter(printer: Printer) = viewModelScope.launch {
        repository.deletePrinter(printer)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAllPrinters()
    }
}