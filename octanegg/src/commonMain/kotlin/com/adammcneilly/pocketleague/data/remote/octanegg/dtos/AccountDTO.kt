package com.adammcneilly.pocketleague.data.remote.octanegg.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a [PlayerDTO] account within the octane.gg API.
 */
@Serializable
data class AccountDTO(
    @SerialName("id")
    val id: String? = null,
    @SerialName("platform")
    val platform: String? = null,
)
