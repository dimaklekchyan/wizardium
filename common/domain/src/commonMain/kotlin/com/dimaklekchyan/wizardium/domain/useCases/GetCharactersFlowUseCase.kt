package com.dimaklekchyan.wizardium.domain.useCases

import com.dimaklekchyan.wizardium.domain.models.Character
import com.dimaklekchyan.wizardium.domain.models.Faculty
import com.dimaklekchyan.wizardium.domain.repositories.CharactersRepository
import kotlinx.coroutines.flow.Flow

interface GetCharactersFlowUseCase {
    operator fun invoke(faculty: Faculty? = null): Flow<List<Character>>
}

internal class GetCharactersFlowUseCaseImpl(
    private val charactersRepository: CharactersRepository
) : GetCharactersFlowUseCase {
    override fun invoke(faculty: Faculty?): Flow<List<Character>> {
        return if (faculty != null) {
            charactersRepository.getCharactersByFacultyFlow(faculty)
        } else {
            charactersRepository.getCharactersFlow()
        }
    }
}
