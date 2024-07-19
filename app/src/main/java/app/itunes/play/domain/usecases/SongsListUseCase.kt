package app.itunes.play.domain.usecases

import app.itunes.play.data.model.Feed
import app.itunes.play.data.utils.Resource
import app.itunes.play.domain.repository.SongsListRepository
import javax.inject.Inject

class SongsListUseCase @Inject constructor(private val songsListRepository: SongsListRepository) {

    suspend fun getItunesSongsList(): Feed? =
        when (val res = songsListRepository.getItunesSongsList()) {
            is Resource.Success -> res.value?.body()
            is Resource.Failure -> null
            else -> null
        }

}