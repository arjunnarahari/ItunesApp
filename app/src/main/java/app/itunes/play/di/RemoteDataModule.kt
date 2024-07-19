package app.itunes.play.di

import app.itunes.play.data.repository.datasource.remote.SongsListRemoteDataSource
import app.itunes.play.data.repository.datasourceimpl.SongsListRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataModule {

    @Binds
    abstract fun bindsSongsListRemoteDataSource(songsListRemoteDataSourceImpl: SongsListRemoteDataSourceImpl): SongsListRemoteDataSource

}