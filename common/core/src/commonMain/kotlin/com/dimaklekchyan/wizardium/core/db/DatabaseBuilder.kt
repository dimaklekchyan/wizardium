package com.dimaklekchyan.wizardium.core.db

import androidx.room.RoomDatabase
import com.dimaklekchyan.wizardium.core.AppContext

expect inline fun <reified T: RoomDatabase> getDatabaseBuilder(
    context: AppContext,
    dbName: String
): RoomDatabase.Builder<T>

expect inline fun <reified T: RoomDatabase> getInMemoryDatabaseBuilder(
    context: AppContext,
): RoomDatabase.Builder<T>