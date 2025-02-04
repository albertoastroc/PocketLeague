package com.adammcneilly.pocketleague.android.designsystem.players

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.adammcneilly.pocketleague.android.designsystem.utils.darken
import com.adammcneilly.pocketleague.core.displaymodels.PlayerDisplayModel

/**
 * Renders a list of [players] onto a card, with our [teamColor] as the background.
 */
@Composable
fun TeamRosterCard(
    players: List<PlayerDisplayModel>,
    teamColor: Color,
    modifier: Modifier = Modifier,
    useDarkTheme: Boolean = isSystemInDarkTheme(),
) {
    val containerColor = if (useDarkTheme) {
        teamColor.darken()
    } else {
        teamColor
    }

    val colors = CardDefaults.cardColors(
        containerColor = containerColor,
        contentColor = Color.White,
    )

    Card(
        colors = colors,
        modifier = modifier
            .fillMaxWidth(),
    ) {
        players.forEachIndexed { index, playerDisplayModel ->
            Text(
                text = playerDisplayModel.tag.toUpperCase(Locale.current),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            )

            if (index != players.lastIndex) {
                Divider(
                    color = Color.White,
                )
            }
        }
    }
}
