package app.itunes.play.domain.repository

import app.itunes.play.data.repository.datasource.local.entity.SongsItem

interface LocalDbRepository {

    suspend fun insertSongs(list : List<SongsItem>)

    suspend fun getSongsList(): List<SongsItem>

    suspend fun getCount() : Int
}