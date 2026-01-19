package com.dimaklekchyan.wizardium.data.mappers

import com.dimaklekchyan.wizardium.core.appJson
import com.dimaklekchyan.wizardium.core.utils.DateFormats
import com.dimaklekchyan.wizardium.core.utils.toLocalDate
import com.dimaklekchyan.wizardium.data.db.entity.CharacterDbEntity
import com.dimaklekchyan.wizardium.data.network.models.CharacterDTO
import com.dimaklekchyan.wizardium.domain.models.Character
import com.dimaklekchyan.wizardium.domain.models.Wand

internal fun CharacterDTO.toDb() = CharacterDbEntity(
    id = id,
    name = name,
    alternateNamesJson = appJson.encodeToString(alternateNames),
    species = species,
    gender = gender,
    faculty = faculty,
    dateOfBirth = dateOfBirth,
    yearOfBirth = yearOfBirth,
    wizard = wizard,
    ancestry = ancestry,
    eyeColour = eyeColour,
    hairColour = hairColour,
    wandWood = wand.wood,
    wandCore = wand.core,
    wandLength = wand.length,
    patronus = patronus,
    hogwartsStudent = hogwartsStudent,
    hogwartsStaff = hogwartsStaff,
    actor = actor,
    alternateActorsJson = appJson.encodeToString(alternateActors),
    alive = alive,
    image = image
)

internal fun CharacterDbEntity.toDomain() = Character(
    id = id,
    name = name,
    alternateNames = appJson.decodeFromString(alternateNamesJson),
    species = species,
    gender = gender,
    faculty = faculty,
    dateOfBirth = dateOfBirth?.toLocalDate(DateFormats.DASHED_DAY_MONTH_YEAR),
    yearOfBirth = yearOfBirth,
    wizard = wizard,
    ancestry = ancestry,
    eyeColour = eyeColour,
    hairColour = hairColour,
    wand = Wand(
        wood = wandWood,
        core = wandCore,
        length = wandLength
    ),
    patronus = patronus,
    hogwartsStudent = hogwartsStudent,
    hogwartsStaff = hogwartsStaff,
    actor = actor,
    alternateActors = appJson.decodeFromString(alternateActorsJson),
    alive = alive,
    image = image,
)