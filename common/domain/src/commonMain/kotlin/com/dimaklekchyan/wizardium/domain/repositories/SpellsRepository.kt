package com.dimaklekchyan.wizardium.domain.repositories

import com.dimaklekchyan.wizardium.domain.models.Spell
import kotlinx.coroutines.flow.Flow

interface SpellsRepository {
    suspend fun refreshSpells(): Result<Unit>
    fun getSpellsFlow(): Flow<List<Spell>>
    suspend fun getSpellById(id: String): Spell?
}
