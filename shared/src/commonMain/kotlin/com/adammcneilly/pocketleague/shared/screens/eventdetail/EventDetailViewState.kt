package com.adammcneilly.pocketleague.shared.screens.eventdetail

import com.adammcneilly.pocketleague.core.displaymodels.EventDetailDisplayModel
import com.adammcneilly.pocketleague.core.displaymodels.TeamOverviewDisplayModel
import com.adammcneilly.pocketleague.shared.screens.ScreenState

/**
 * Defines the UI state of the event detail screen.
 */
data class EventDetailViewState(
    val eventId: String = "",
    val eventDetail: EventDetailDisplayModel? = EventDetailDisplayModel.placeholder,
    val participants: List<TeamOverviewDisplayModel> = List(3) {
        TeamOverviewDisplayModel.placeholder
    },
) : ScreenState {

    override val title: String?
        get() = eventDetail?.name?.takeIf {
            !eventDetail.isPlaceholder
        }
}
