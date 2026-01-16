package com.dimaklekchyan.wizardium.data.network.api

import com.dimaklekchyan.wizardium.core.AppConstants
import com.dimaklekchyan.wizardium.core.network.BaseApi
import com.dimaklekchyan.wizardium.data.network.models.CharacterDTO
import com.dimaklekchyan.wizardium.data.network.models.FacultyDTO
import io.ktor.client.HttpClient

interface CharactersApi {
    suspend fun getCharacters(): Result<List<CharacterDTO>>
    suspend fun getCharactersByFaculty(faculty: FacultyDTO): Result<List<CharacterDTO>>
    suspend fun getCharacterById(id: String): Result<CharacterDTO?>
}

internal class CharactersApiImpl(
    httpClient: HttpClient
): BaseApi(httpClient), CharactersApi {
    override suspend fun getCharacters(): Result<List<CharacterDTO>> {
        return get<List<CharacterDTO>>(
            url = AppConstants.HP_API + "/characters"
        )
    }

    override suspend fun getCharactersByFaculty(faculty: FacultyDTO): Result<List<CharacterDTO>> {
        return get<List<CharacterDTO>>(
            url = AppConstants.HP_API + "characters/house/${faculty.name.lowercase()}"
        )
    }

    override suspend fun getCharacterById(id: String): Result<CharacterDTO?> {
        return get<CharacterDTO>(
            url = AppConstants.HP_API + "character/$id"
        )
    }
}