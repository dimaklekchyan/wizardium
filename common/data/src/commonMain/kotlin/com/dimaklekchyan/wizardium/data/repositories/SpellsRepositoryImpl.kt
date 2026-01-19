package com.dimaklekchyan.wizardium.data.repositories

import com.dimaklekchyan.wizardium.data.db.dao.SpellDao
import com.dimaklekchyan.wizardium.data.mappers.toDb
import com.dimaklekchyan.wizardium.data.mappers.toDomain
import com.dimaklekchyan.wizardium.data.network.api.SpellsApi
import com.dimaklekchyan.wizardium.domain.models.Spell
import com.dimaklekchyan.wizardium.domain.repositories.SpellsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class SpellsRepositoryImpl(
    private val spellsApi: SpellsApi,
    private val spellDao: SpellDao
) : SpellsRepository {

    override suspend fun refreshSpells(): Result<Unit> {
        return spellsApi.getSpells().fold(
            onSuccess = { dto ->
                try {
                    val dbEntities = dto.map { it.toDb() }
                    spellDao.insertSpells(dbEntities)
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

    override fun getSpellsFlow(): Flow<List<Spell>> {
        return spellDao.getAllSpells().map { list ->
            list.map { it.toDomain() }
        }
    }

    override suspend fun getSpellById(id: String): Spell? {
        return spellDao.getSpellById(id)?.toDomain()
    }
}
