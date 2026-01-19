package com.dimaklekchyan.wizardium.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spells")
data class SpellDbEntity(
    @PrimaryKey
    @ColumnInfo("id") val id: String,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("description") val description: String,
)