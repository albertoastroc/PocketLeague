package com.adammcneilly.pocketleague.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.logging.SIMPLE
import io.ktor.http.ContentType
import kotlinx.serialization.json.Json

/**
 * A default implementation of an [HttpClient] that will use an engine defined
 * by the platform it's being used on. This allows us to override for tests.
 */
fun defaultHttpClient(
    engine: HttpClientEngine = CIO.create(),
) = HttpClient(engine) {
    install(JsonFeature) {
        serializer = KotlinxSerializer(
            Json {
                ignoreUnknownKeys = true
                acceptContentTypes = acceptContentTypes + ContentType.Any
            },
        )
    }
    install(Logging) {
        logger = Logger.SIMPLE
        level = LogLevel.ALL
    }
}
