package com.adammcneilly.pocketleague.event.implementation.smashgg.mappers

import com.adammcneilly.pocketleague.core.models.Team
import com.adammcneilly.pocketleague.event.implementation.graphql.fragment.EventEntrantFragment
import com.adammcneilly.pocketleague.event.implementation.graphql.fragment.EventPlayerFragment

/**
 * Converting an [EventEntrantFragment] from the smash.gg API into a [Team] from our domain.
 */
fun EventEntrantFragment?.toTeam(): Team {
    return Team(
        name = this?.name.orEmpty(),
        lightThemeLogoImageUrl = this?.team?.images?.firstOrNull()?.url,
        darkThemeLogoImageUrl = this?.team?.images?.firstOrNull()?.url,
        roster = this?.team?.members?.mapNotNull { member ->
            member?.player?.eventPlayerFragment.let(EventPlayerFragment?::toPlayer)
        }.orEmpty(),
    )
}
