package com.dimaklekchyan.wizardium.shared

import com.dimaklekchyan.wizardium.core.coreDiModule
import com.dimaklekchyan.wizardium.data.dataDiModule
import org.koin.core.module.Module

val diModules = listOf<Module>(
    coreDiModule,
    dataDiModule
)
