package com.dimaklekchyan.wizardium.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dimaklekchyan.wizardium.data.db.entity.SpellDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SpellDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSpells(spells: List<SpellDbEntity>)

    @Query("SELECT * FROM spells")
    fun getAllSpells(): Flow<List<SpellDbEntity>>

    @Query("SELECT * FROM spells WHERE id = :id")
    suspend fun getSpellById(id: String): SpellDbEntity?

    @Query("DELETE FROM spells")
    suspend fun clearAll()
}
