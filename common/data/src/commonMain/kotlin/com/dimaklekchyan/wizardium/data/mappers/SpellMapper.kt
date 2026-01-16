package com.dimaklekchyan.wizardium.data.mappers

import com.dimaklekchyan.wizardium.data.network.models.SpellDTO
import com.dimaklekchyan.wizardium.domain.models.Spell

internal fun SpellDTO.toDomain() = Spell(
    id = id,
    name = name,
    description = description
)