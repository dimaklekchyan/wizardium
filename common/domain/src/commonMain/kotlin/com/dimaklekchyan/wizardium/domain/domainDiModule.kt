package com.dimaklekchyan.wizardium.domain

import com.dimaklekchyan.wizardium.domain.useCases.GetCharacterByIdUseCase
import com.dimaklekchyan.wizardium.domain.useCases.GetCharacterByIdUseCaseImpl
import com.dimaklekchyan.wizardium.domain.useCases.GetCharactersFlowUseCase
import com.dimaklekchyan.wizardium.domain.useCases.GetCharactersFlowUseCaseImpl
import com.dimaklekchyan.wizardium.domain.useCases.GetSpellByIdUseCase
import com.dimaklekchyan.wizardium.domain.useCases.GetSpellByIdUseCaseImpl
import com.dimaklekchyan.wizardium.domain.useCases.GetSpellsFlowUseCase
import com.dimaklekchyan.wizardium.domain.useCases.GetSpellsFlowUseCaseImpl
import com.dimaklekchyan.wizardium.domain.useCases.RefreshCharactersUseCase
import com.dimaklekchyan.wizardium.domain.useCases.RefreshCharactersUseCaseImpl
import com.dimaklekchyan.wizardium.domain.useCases.RefreshSpellsUseCase
import com.dimaklekchyan.wizardium.domain.useCases.RefreshSpellsUseCaseImpl
import org.koin.dsl.module

val domainDiModule = module {
    factory<RefreshCharactersUseCase> { RefreshCharactersUseCaseImpl(get()) }
    factory<GetCharactersFlowUseCase> { GetCharactersFlowUseCaseImpl(get()) }
    factory<GetCharacterByIdUseCase> { GetCharacterByIdUseCaseImpl(get()) }

    factory<RefreshSpellsUseCase> { RefreshSpellsUseCaseImpl(get()) }
    factory<GetSpellsFlowUseCase> { GetSpellsFlowUseCaseImpl(get()) }
    factory<GetSpellByIdUseCase> { GetSpellByIdUseCaseImpl(get()) }
}
