package com.dimaklekchyan.wizardium.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterDbEntity(
    @PrimaryKey
    @ColumnInfo("id") val id: String,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("alternateNamesJson") val alternateNamesJson: String,
    @ColumnInfo("species") val species: String,
    @ColumnInfo("gender") val gender: String,
    @ColumnInfo("faculty") val faculty: String,
    @ColumnInfo("dateOfBirth") val dateOfBirth: String?,
    @ColumnInfo("yearOfBirth") val yearOfBirth: Int?,
    @ColumnInfo("wizard") val wizard: Boolean,
    @ColumnInfo("ancestry") val ancestry: String,
    @ColumnInfo("eyeColour") val eyeColour: String,
    @ColumnInfo("hairColour") val hairColour: String,
    @ColumnInfo("wandWood") val wandWood: String,
    @ColumnInfo("wandCore") val wandCore: String,
    @ColumnInfo("wandLength") val wandLength: Double?,
    @ColumnInfo("patronus") val patronus: String,
    @ColumnInfo("hogwartsStudent") val hogwartsStudent: Boolean,
    @ColumnInfo("hogwartsStaff") val hogwartsStaff: Boolean,
    @ColumnInfo("actor") val actor: String,
    @ColumnInfo("alternateActorsJson") val alternateActorsJson: String,
    @ColumnInfo("alive") val alive: Boolean,
    @ColumnInfo("image") val image: String
)
