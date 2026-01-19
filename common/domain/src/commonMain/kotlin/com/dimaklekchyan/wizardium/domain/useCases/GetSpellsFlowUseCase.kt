package com.dimaklekchyan.wizardium.domain.useCases

import com.dimaklekchyan.wizardium.domain.models.Spell
import com.dimaklekchyan.wizardium.domain.repositories.SpellsRepository
import kotlinx.coroutines.flow.Flow

interface GetSpellsFlowUseCase {
    operator fun invoke(): Flow<List<Spell>>
}

internal class GetSpellsFlowUseCaseImpl(
    private val spellsRepository: SpellsRepository
) : GetSpellsFlowUseCase {
    override fun invoke(): Flow<List<Spell>> {
        return spellsRepository.getSpellsFlow()
    }
}
