package com.adammcneilly.pocketleague.data.team

import com.adammcneilly.pocketleague.core.models.DataState
import com.adammcneilly.pocketleague.core.models.Team
import com.adammcneilly.pocketleague.data.octanegg.models.OctaneGGTeamDetail
import com.adammcneilly.pocketleague.data.octanegg.models.OctaneGGTeamListResponse
import com.adammcneilly.pocketleague.data.octanegg.models.toTeam
import com.adammcneilly.pocketleague.data.remote.BaseKTORClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.isActive

/**
 * A custom implementation of [TeamRepository] that will send and request data
 * from an octane gg [apiClient].
 */
class OctaneGGTeamRepository(
    private val apiClient: BaseKTORClient,
) : TeamRepository {
    override fun getFavoriteTeams(): Flow<List<Team>> {
        throw UnsupportedOperationException("Fetching favorite teams is not supported by the octane.gg API.")
    }

    override fun getActiveRLCSTeams(): Flow<List<Team>> {
        return flow {
            val apiResponse = apiClient.getResponse<OctaneGGTeamListResponse>(
                endpoint = ACTIVE_TEAMS_ENDPOINT,
            ).map { octaneGGTeamListResponse ->
                octaneGGTeamListResponse.teams
                    ?.map(OctaneGGTeamDetail::toTeam)
                    .orEmpty()
            }

            // If an error occurs, we should log that.

            val teamList = (apiResponse as? DataState.Success)
                ?.data
                ?.map {
                    // For any team that is requested via this API call, we want to store it
                    // as an active team in our local data source further up this data flow.
                    it.copy(isActive = true)
                }
                .orEmpty()

            emit(teamList)
        }
    }

    override suspend fun insertTeams(teams: List<Team>) {
        throw UnsupportedOperationException("Inserting teams is not supported by the octane.gg API.")
    }

    override suspend fun updateIsFavorite(teamId: String, isFavorite: Boolean) {
        throw UnsupportedOperationException("Favoriting teams is not supported by the octane.gg API.")
    }

    companion object {
        const val ACTIVE_TEAMS_ENDPOINT = "/teams/active"
    }
}
