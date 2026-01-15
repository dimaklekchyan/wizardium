package com.dimaklekchyan.wizardium.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WandDTO(
    @SerialName("wood")
    val wood: String,

    @SerialName("core")
    val core: String,

    @SerialName("length")
    val length: Double?
)