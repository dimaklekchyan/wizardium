package com.dimaklekchyan.wizardium.core.db

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.NativeSQLiteDriver
import com.dimaklekchyan.wizardium.core.AppContext
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

@OptIn(ExperimentalForeignApi::class)
actual inline fun <reified T: RoomDatabase> getDatabaseBuilder(
    context: AppContext,
    dbName: String
): RoomDatabase.Builder<T> {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    val dbFilePath = "${requireNotNull(documentDirectory)}/$dbName"
    return Room.databaseBuilder<T>(dbFilePath)
        .setDriver(NativeSQLiteDriver())
}

actual inline fun <reified T: RoomDatabase> getInMemoryDatabaseBuilder(
    context: AppContext,
): RoomDatabase.Builder<T> {
    return Room.inMemoryDatabaseBuilder<T>()
        .setDriver(NativeSQLiteDriver())
}