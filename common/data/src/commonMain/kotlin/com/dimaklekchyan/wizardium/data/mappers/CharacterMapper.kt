package com.dimaklekchyan.wizardium.data.mappers

import com.dimaklekchyan.wizardium.core.utils.DateFormats
import com.dimaklekchyan.wizardium.core.utils.toLocalDate
import com.dimaklekchyan.wizardium.data.network.models.CharacterDTO
import com.dimaklekchyan.wizardium.domain.models.Character

internal fun CharacterDTO.toDomain() = Character(
    id = id,
    name = name,
    alternateNames = alternateNames,
    species = species,
    gender = gender,
    house = house,
    dateOfBirth = dateOfBirth?.toLocalDate(DateFormats.DASHED_DAY_MONTH_YEAR),
    yearOfBirth = yearOfBirth,
    wizard = wizard,
    ancestry = ancestry,
    eyeColour = eyeColour,
    hairColour = hairColour,
    wand = wand.toDomain(),
    patronus = patronus,
    hogwartsStudent = hogwartsStudent,
    hogwartsStaff = hogwartsStaff,
    actor = actor,
    alternateActors = alternateActors,
    alive = alive,
    image = image,
)