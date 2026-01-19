package com.dimaklekchyan.wizardium.data.network.api

import com.dimaklekchyan.wizardium.core.AppConstants
import com.dimaklekchyan.wizardium.data.network.BaseApi
import com.dimaklekchyan.wizardium.data.network.models.SpellDTO
import io.ktor.client.HttpClient

interface SpellsApi {
    suspend fun getSpells(): Result<List<SpellDTO>>
}

internal class SpellsApiImpl(
    httpClient: HttpClient
): BaseApi(httpClient), SpellsApi {
    override suspend fun getSpells(): Result<List<SpellDTO>> {
        return get<List<SpellDTO>>(
            url = AppConstants.HP_API + "/spells"
        )
    }
}