package app.itunes.play.data.repository.datasource.remote

import app.itunes.play.data.model.Feed
import retrofit2.Response

interface SongsListRemoteDataSource {

    suspend fun getItunesSongsList(): Response<Feed?>

}