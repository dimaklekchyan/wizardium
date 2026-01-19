package com.dimaklekchyan.wizardium.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dimaklekchyan.wizardium.data.db.entity.CharacterDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<CharacterDbEntity>)

    @Query("SELECT * FROM characters")
    fun getAllCharacters(): Flow<List<CharacterDbEntity>>

    @Query("SELECT * FROM characters WHERE faculty = :faculty")
    fun getCharactersByFaculty(faculty: String): Flow<List<CharacterDbEntity>>

    @Query("SELECT * FROM characters WHERE id = :id")
    suspend fun getCharacterById(id: String): CharacterDbEntity?

    @Query("DELETE FROM characters")
    suspend fun clearAll()
}
