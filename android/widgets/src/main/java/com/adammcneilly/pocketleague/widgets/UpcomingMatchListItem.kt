package com.adammcneilly.pocketleague.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.layout.Column
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.adammcneilly.pocketleague.core.displaymodels.MatchDetailDisplayModel

/**
 * Renders a [displayModel] object inside a list in our [UpcomingMatchesWidget].
 */
@Composable
fun UpcomingMatchListItem(
    displayModel: MatchDetailDisplayModel,
    contentColor: ColorProvider,
    modifier: GlanceModifier = GlanceModifier,
) {
    Column(
        modifier = modifier
            .padding(16.dp),
    ) {
        Text(
            text = displayModel.eventName,
            style = TextStyle(
                color = contentColor,
                fontWeight = FontWeight.Bold,
            ),
        )

        Text(
            text = displayModel.relativeDateTime,
            style = TextStyle(
                color = contentColor,
                fontSize = 10.sp,
            ),
        )

        val blueTeamName = displayModel.blueTeamResult.team.name
        val orangeTeamName = displayModel.orangeTeamResult.team.name
        val teamNames = "$blueTeamName vs $orangeTeamName"

        Text(
            text = teamNames,
            style = TextStyle(
                color = contentColor,
            ),
        )
    }
}
