package com.dimaklekchyan.wizardium.core.db

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.AndroidSQLiteDriver
import com.dimaklekchyan.wizardium.core.AppContext

actual inline fun <reified T: RoomDatabase> getDatabaseBuilder(
    context: AppContext,
    dbName: String
): RoomDatabase.Builder<T> {
    val dbFile = context.context.getDatabasePath(dbName)
    return Room.databaseBuilder<T>(
        context = context.context,
        name = dbFile.absolutePath
    ).setDriver(AndroidSQLiteDriver())
}

actual inline fun <reified T: RoomDatabase> getInMemoryDatabaseBuilder(
    context: AppContext,
): RoomDatabase.Builder<T> {
    return Room.inMemoryDatabaseBuilder<T>(
        context = context.context
    ).setDriver(AndroidSQLiteDriver())
}