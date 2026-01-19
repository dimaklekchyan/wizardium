package com.dimaklekchyan.wizardium.domain.useCases

import com.dimaklekchyan.wizardium.domain.models.Spell
import com.dimaklekchyan.wizardium.domain.repositories.SpellsRepository

interface GetSpellByIdUseCase {
    suspend operator fun invoke(id: String): Spell?
}

internal class GetSpellByIdUseCaseImpl(
    private val spellsRepository: SpellsRepository
) : GetSpellByIdUseCase {
    override suspend fun invoke(id: String): Spell? {
        return spellsRepository.getSpellById(id)
    }
}
