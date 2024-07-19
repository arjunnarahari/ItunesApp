package app.itunes.play.data.repository.datasource.local

import app.itunes.play.data.repository.datasource.local.entity.SongsItem
import app.itunes.play.domain.repository.LocalDbRepository
import javax.inject.Inject

class LocalDbRepositoryImpl @Inject constructor(private val dbDao: ItunesSongsDao) : LocalDbRepository {

    override suspend fun insertSongs(list: List<SongsItem>) {
        dbDao.insertSongs(list)
    }

    override suspend fun getSongsList(): List<SongsItem> {
        return dbDao.getSongsList()
    }

    override suspend fun getCount(): Int {
        return dbDao.getSongsListCount()
    }


}