package com.dimaklekchyan.wizardium.domain.useCases

import com.dimaklekchyan.wizardium.domain.repositories.CharactersRepository

interface RefreshCharactersUseCase {
    suspend operator fun invoke(): Result<Unit>
}

internal class RefreshCharactersUseCaseImpl(
    private val charactersRepository: CharactersRepository
): RefreshCharactersUseCase {
    override suspend fun invoke(): Result<Unit> {
        return charactersRepository.refreshCharacters()
    }
}
