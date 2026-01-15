package com.dimaklekchyan.wizardium.data.network.api

import com.dimaklekchyan.wizardium.core.AppConstants
import com.dimaklekchyan.wizardium.core.network.BaseApi
import com.dimaklekchyan.wizardium.data.network.models.CharacterDTO
import com.dimaklekchyan.wizardium.data.network.models.FacultyDTO
import com.dimaklekchyan.wizardium.data.network.models.SpellDTO
import io.ktor.client.HttpClient

interface HarryPotterApi {
    suspend fun getCharacters(): Result<List<CharacterDTO>>
    suspend fun getCharactersByFaculty(faculty: FacultyDTO): Result<List<CharacterDTO>>
    suspend fun getSpells(): Result<List<SpellDTO>>
    suspend fun getCharacterById(id: String): Result<CharacterDTO?>
}

internal class HarryPotterApiImpl(
    httpClient: HttpClient
): BaseApi(httpClient), HarryPotterApi {
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

    override suspend fun getSpells(): Result<List<SpellDTO>> {
        return get<List<SpellDTO>>(
            url = AppConstants.HP_API + "spells"
        )
    }
}