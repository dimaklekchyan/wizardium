package com.dimaklekchyan.wizardium.data.repositories

import com.dimaklekchyan.wizardium.data.db.dao.CharacterDao
import com.dimaklekchyan.wizardium.data.mappers.toDb
import com.dimaklekchyan.wizardium.data.mappers.toDomain
import com.dimaklekchyan.wizardium.data.network.api.CharactersApi
import com.dimaklekchyan.wizardium.domain.models.Character
import com.dimaklekchyan.wizardium.domain.models.Faculty
import com.dimaklekchyan.wizardium.domain.repositories.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class CharactersRepositoryImpl(
    private val charactersApi: CharactersApi,
    private val characterDao: CharacterDao
) : CharactersRepository {

    override suspend fun refreshCharacters(): Result<Unit> {
        return charactersApi.getCharacters().fold(
            onSuccess = { dto ->
                try {
                    val dbEntities = dto.map { it.toDb() }
                    characterDao.insertCharacters(dbEntities)
                    Result.success(Unit)
                } catch (e: Exception) {
                    Result.failure(e)
                }
            },
            onFailure = { error ->
                Result.failure(error)
            }
        )
    }

    override fun getCharactersFlow(): Flow<List<Character>> {
        return characterDao.getAllCharacters().map { list ->
            list.map { it.toDomain() }
        }
    }

    override fun getCharactersByFacultyFlow(faculty: Faculty): Flow<List<Character>> {
        return characterDao.getCharactersByFaculty(faculty.name).map { list ->
            list.map { it.toDomain() }
        }
    }

    override suspend fun getCharacterById(id: String): Character? {
        return characterDao.getCharacterById(id)?.toDomain()
    }
}
