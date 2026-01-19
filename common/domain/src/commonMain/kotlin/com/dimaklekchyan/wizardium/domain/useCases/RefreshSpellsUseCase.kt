package com.dimaklekchyan.wizardium.domain.useCases

import com.dimaklekchyan.wizardium.domain.repositories.SpellsRepository

interface RefreshSpellsUseCase {
    suspend operator fun invoke(): Result<Unit>
}

internal class RefreshSpellsUseCaseImpl(
    private val spellsRepository: SpellsRepository
) : RefreshSpellsUseCase {
    override suspend fun invoke(): Result<Unit> {
        return spellsRepository.refreshSpells()
    }
}
