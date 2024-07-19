package app.itunes.play.data.utils

import app.itunes.play.BuildConfig

object ApiEndpointConstants {

    fun baseUrl(): String {
        return BuildConfig.baseUrl
    }

    const val FETCH_SONGS = "WebObjects/MZStoreServices.woa/ws/RSS/topsongs/limit=25/xml"
}