package app.itunes.play.domain.repository

import app.itunes.play.data.model.Feed
import app.itunes.play.data.utils.Resource
import retrofit2.Response

interface SongsListRepository {

    suspend fun getItunesSongsList(
    ): Resource<Response<Feed?>>
}