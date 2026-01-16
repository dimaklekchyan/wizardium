package com.dimaklekchyan.wizardium.data.mappers

import com.dimaklekchyan.wizardium.data.network.models.WandDTO
import com.dimaklekchyan.wizardium.domain.models.Wand

internal fun WandDTO.toDomain() = Wand(
    wood = wood,
    core = core,
    length = length,
)