package com.dimaklekchyan.wizardium.data.mappers

import com.dimaklekchyan.wizardium.data.network.models.FacultyDTO
import com.dimaklekchyan.wizardium.domain.models.Faculty

internal fun FacultyDTO.toDomain() = when(this) {
    FacultyDTO.Gryffindor -> Faculty.Gryffindor
    FacultyDTO.Slytherin -> Faculty.Slytherin
    FacultyDTO.Ravenclaw -> Faculty.Ravenclaw
    FacultyDTO.Hufflepuff -> Faculty.Hufflepuff
}

internal fun Faculty.toDTO() = when(this) {
    Faculty.Gryffindor -> FacultyDTO.Gryffindor
    Faculty.Slytherin -> FacultyDTO.Slytherin
    Faculty.Ravenclaw -> FacultyDTO.Ravenclaw
    Faculty.Hufflepuff -> FacultyDTO.Hufflepuff
}