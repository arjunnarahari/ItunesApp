package app.itunes.play.data.repository.repositoryimpl

import app.itunes.play.data.model.Feed
import app.itunes.play.data.repository.datasource.remote.SongsListRemoteDataSource
import app.itunes.play.data.utils.Resource
import app.itunes.play.data.utils.safeApiCall
import app.itunes.play.domain.repository.SongsListRepository
import retrofit2.Response
import javax.inject.Inject

class SongsListRepositoryImpl @Inject constructor(private val songsListRemoteDataSource: SongsListRemoteDataSource): SongsListRepository {

    override suspend fun getItunesSongsList(): Resource<Response<Feed?>> {
        return safeApiCall {
            songsListRemoteDataSource.getItunesSongsList()
        }
    }
}