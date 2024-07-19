package app.itunes.play.data.repository.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import app.itunes.play.data.repository.datasource.local.ItunesSongsDao
import app.itunes.play.data.repository.datasource.local.entity.SongsItem

@Database(
    entities = [SongsItem::class], version = 1, exportSchema = false
)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun getAppDao(): ItunesSongsDao

}