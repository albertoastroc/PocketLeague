package com.adammcneilly.pocketleague.core.di

import com.adammcneilly.pocketleague.event.api.EventRepository
import com.adammcneilly.pocketleague.feature.eventsummarylist.domain.GetEventSummariesUseCase
import com.adammcneilly.pocketleague.feature.eventsummarylist.domain.GetEventSummariesUseCaseImpl
import com.adammcneilly.pocketleague.shared.data.phase.PhaseRepository
import com.adammcneilly.pocketleague.shared.eventoverview.domain.GetEventOverviewUseCase
import com.adammcneilly.pocketleague.shared.eventoverview.domain.GetEventOverviewUseCaseImpl
import com.adammcneilly.pocketleague.shared.phasedetail.domain.GetPhaseDetailUseCase
import com.adammcneilly.pocketleague.shared.phasedetail.domain.GetPhaseDetailUseCaseImpl
import com.adammcneilly.pocketleague.teamlist.domain.usecases.FetchAllTeamsUseCase
import com.adammcneilly.pocketleague.teamlist.domain.usecases.FetchAllTeamsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * A collection of all use case dependencies in the application.
 */
@Module
@InstallIn(SingletonComponent::class)
@Suppress("UndocumentedPublicFunction")
abstract class UseCaseModule {
    @Binds
    abstract fun bindFetchAllTeamsUseCase(
        fetchAllTeamsUseCase: FetchAllTeamsUseCaseImpl,
    ): FetchAllTeamsUseCase

    companion object {
        @Provides
        fun provideGetUpcomingEventSummariesUseCase(
            repository: EventRepository,
        ): GetEventSummariesUseCase {
            return GetEventSummariesUseCaseImpl(
                repository = repository,
            )
        }

        @Provides
        fun provideGetEventOverviewUseCase(
            repository: com.adammcneilly.pocketleague.shared.data.event.EventRepository,
        ): GetEventOverviewUseCase {
            return GetEventOverviewUseCaseImpl(
                repository = repository,
            )
        }

        @Provides
        fun provideGetPhaseDetailUseCase(
            repository: PhaseRepository,
        ): GetPhaseDetailUseCase {
            return GetPhaseDetailUseCaseImpl(
                repository = repository,
            )
        }
    }
}
