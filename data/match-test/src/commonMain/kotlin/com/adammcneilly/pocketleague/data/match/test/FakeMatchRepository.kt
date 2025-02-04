package com.adammcneilly.pocketleague.data.match.test

import com.adammcneilly.pocketleague.core.models.DataState
import com.adammcneilly.pocketleague.core.models.Match
import com.adammcneilly.pocketleague.data.match.MatchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeMatchRepository : MatchRepository {
    val matchDetailsById: MutableMap<String, Match> = mutableMapOf()

    lateinit var pastWeeksMatches: List<Match>

    lateinit var upcomingMatches: List<Match>

    override fun getMatchDetail(matchId: String): Flow<Match> {
        return flowOf(matchDetailsById[matchId]!!)
    }

    override fun getPastWeeksMatches(): Flow<List<Match>> {
        return flowOf(pastWeeksMatches)
    }

    override fun getUpcomingMatches(): Flow<List<Match>> {
        return flowOf(upcomingMatches)
    }

    override suspend fun fetchAndPersistUpcomingMatches(): DataState<Unit> {
        return DataState.Success(Unit)
    }

    override fun getMatchesForEventStage(eventId: String, stageId: String): Flow<List<Match>> {
        return flowOf(emptyList())
    }

    override fun getPastWeeksMatchesForTeams(teamIds: List<String>): Flow<List<Match>> {
        return flowOf(emptyList())
    }
}
