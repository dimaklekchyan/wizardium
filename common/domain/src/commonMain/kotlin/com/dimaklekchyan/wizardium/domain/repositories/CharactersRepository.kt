package com.dimaklekchyan.wizardium.domain.repositories

import com.dimaklekchyan.wizardium.domain.models.Character
import com.dimaklekchyan.wizardium.domain.models.Faculty
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    suspend fun refreshCharacters(): Result<Unit>
    fun getCharactersFlow(): Flow<List<Character>>
    fun getCharactersByFacultyFlow(faculty: Faculty): Flow<List<Character>>
    suspend fun getCharacterById(id: String): Character?
}