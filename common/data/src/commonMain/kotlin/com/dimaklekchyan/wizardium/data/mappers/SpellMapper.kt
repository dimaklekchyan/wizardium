package com.dimaklekchyan.wizardium.data.mappers

import com.dimaklekchyan.wizardium.data.db.entity.SpellDbEntity
import com.dimaklekchyan.wizardium.data.network.models.SpellDTO
import com.dimaklekchyan.wizardium.domain.models.Spell

internal fun SpellDTO.toDb() = SpellDbEntity(
    id = id,
    name = name,
    description = description
)

internal fun SpellDbEntity.toDomain() = Spell(
    id = id,
    name = name,
    description = description
)
