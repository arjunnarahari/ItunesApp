package app.itunes.play.data.api

import app.itunes.play.data.model.Feed
import app.itunes.play.data.utils.ApiEndpointConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET(ApiEndpointConstants.FETCH_SONGS)
    suspend fun getItunesSongsList(
    ): Response<Feed?>

}