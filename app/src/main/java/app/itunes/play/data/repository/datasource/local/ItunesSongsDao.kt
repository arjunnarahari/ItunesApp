package app.itunes.play.data.repository.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.itunes.play.data.repository.datasource.local.entity.SongsItem

@Dao
interface ItunesSongsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSongs(list: List<SongsItem>)

    @Query("SELECT * FROM SongsItem")
    fun getSongsList(): List<SongsItem>

    @Query("SELECT count(*) FROM SongsItem")
    fun getSongsListCount(): Int
}