package app.itunes.play.domain.usecases

import android.util.Log
import app.itunes.play.data.model.Entry
import app.itunes.play.data.repository.datasource.local.entity.SongsItem
import app.itunes.play.domain.repository.LocalDbRepository
import javax.inject.Inject

class LocalDbUseCase @Inject constructor(private val localDbRepository: LocalDbRepository) {

    suspend fun getSongsCount(): Int {
        return localDbRepository.getCount()
    }

    suspend fun insertSongs(list: List<SongsItem>) {
        Log.i("itemList",""+list)
        if (getSongsCount() == 0) {
            localDbRepository.insertSongs(list)
        }
    }

    suspend fun getSongsList(): List<SongsItem> {
        return localDbRepository.getSongsList()
    }


}