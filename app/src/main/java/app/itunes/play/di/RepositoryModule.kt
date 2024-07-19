package app.itunes.play.di

import app.itunes.play.data.repository.datasource.local.LocalDbRepositoryImpl
import app.itunes.play.data.repository.repositoryimpl.SongsListRepositoryImpl
import app.itunes.play.domain.repository.LocalDbRepository
import app.itunes.play.domain.repository.SongsListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindsSongsListRepository(loginRepositoryImpl: SongsListRepositoryImpl): SongsListRepository

    @Binds
    abstract fun bindsSongsListLocalRepository(localDbRepositoryImpl: LocalDbRepositoryImpl): LocalDbRepository
}