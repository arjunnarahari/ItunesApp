package app.itunes.play.di

import android.content.Context
import androidx.room.Room
import app.itunes.play.data.repository.datasource.local.ItunesSongsDao
import app.itunes.play.data.repository.datasource.local.database.AppRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RoomDbModule {

    @Provides
    fun provideAppDao(@ApplicationContext context: Context): ItunesSongsDao {
        return Room.databaseBuilder(context, AppRoomDatabase::class.java, "itunes_songs_db")
            .fallbackToDestructiveMigration()
            .build()
            .getAppDao()
    }
}