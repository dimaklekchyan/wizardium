package com.dimaklekchyan.wizardium.domain.useCases

import com.dimaklekchyan.wizardium.domain.models.Character
import com.dimaklekchyan.wizardium.domain.repositories.CharactersRepository

interface GetCharacterByIdUseCase {
    suspend operator fun invoke(id: String): Character?
}

internal class GetCharacterByIdUseCaseImpl(
    private val charactersRepository: CharactersRepository
) : GetCharacterByIdUseCase {
    override suspend fun invoke(id: String): Character? {
        return charactersRepository.getCharacterById(id)
    }
}
