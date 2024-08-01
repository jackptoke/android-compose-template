package dev.toke.dispatch3.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.toke.dispatch3.data.AmeDatabase
import dev.toke.dispatch3.data.EmployeeDatabaseDao
import dev.toke.dispatch3.data.PrinterDatabaseDao
import dev.toke.dispatch3.repository.EmployeeRepository
import dev.toke.dispatch3.repository.PrinterRepository
import dev.toke.dispatch3.utils.LocalDateTimeConverter
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideAmeDatabase(@ApplicationContext context: Context): AmeDatabase =
        Room.databaseBuilder(context, AmeDatabase::class.java, name = "ame_db")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun providePrinterDao(ameDatabase: AmeDatabase): PrinterDatabaseDao = ameDatabase.printerDao()

    @Singleton
    @Provides
    fun provideEmployeeDao(ameDatabase: AmeDatabase): EmployeeDatabaseDao = ameDatabase.employeeDao()

    @Singleton
    @Provides
    fun providePrinterRepository(printerDatabaseDao: PrinterDatabaseDao): PrinterRepository = PrinterRepository(printerDatabaseDao)

    @Singleton
    @Provides
    fun provideEmployeeRepository(employeeDatabaseDao: EmployeeDatabaseDao): EmployeeRepository = EmployeeRepository(employeeDatabaseDao)
}