package app.itunes.play.domain.mappers

import app.itunes.play.data.model.Entry
import app.itunes.play.data.model.Link
import app.itunes.play.data.repository.datasource.local.entity.SongsItem

/**
 * This is the mapper class where we convert the existing model class
 * Entry(for online) to SongsItem(for local db) and vice versa
 * **/

fun mapToSongsItemList(list: List<Entry>): List<SongsItem> {
    val songsItemList = arrayListOf<SongsItem>()
    list.mapIndexed { index, item ->

        songsItemList.add(
            SongsItem(
                id = item.id!!,
                title = item.title,
                imageUrl = item.imageUrl,
                artist = item.artist,
                price = item.price,
                duration = item.link.duration,
                audioLink = item.link.audioLink,
                //content = item.content

            )
        )
    }
    return songsItemList
}

fun mapToEntryItemList(list: List<SongsItem>): List<Entry> {
    val songsItemList = arrayListOf<Entry>()
    list.mapIndexed { index, item ->

        songsItemList.add(
            Entry(
                id = item.id,
                title = item.title,
                imageUrl = item.imageUrl,
                artist = item.artist,
                price = item.price,
                link = Link(duration = item.duration, audioLink = item.audioLink),
                //content = item.content!!
            )
        )
    }
    return songsItemList
}
