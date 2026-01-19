package com.dimaklekchyan.wizardium.data.db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.dimaklekchyan.wizardium.data.db.dao.CharacterDao
import com.dimaklekchyan.wizardium.data.db.dao.SpellDao
import com.dimaklekchyan.wizardium.data.db.entity.CharacterDbEntity
import com.dimaklekchyan.wizardium.data.db.entity.SpellDbEntity

@Database(
    entities = [
        CharacterDbEntity::class,
        SpellDbEntity::class
    ],
    version = 1,
    exportSchema = true
)
@ConstructedBy(AppDBConstructor::class)
abstract class AppDB : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun spellDao(): SpellDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDBConstructor : RoomDatabaseConstructor<AppDB>

internal const val AppDBName = "AppDB"
