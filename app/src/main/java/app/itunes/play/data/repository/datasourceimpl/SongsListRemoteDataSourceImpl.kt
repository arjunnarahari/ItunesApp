package app.itunes.play.data.repository.datasourceimpl

import app.itunes.play.data.api.ApiInterface
import app.itunes.play.data.model.Feed
import app.itunes.play.data.repository.datasource.remote.SongsListRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class SongsListRemoteDataSourceImpl @Inject constructor(private val apiInterface: ApiInterface) :
    SongsListRemoteDataSource {

    override suspend fun getItunesSongsList(): Response<Feed?> {
        return apiInterface.getItunesSongsList()
    }
}