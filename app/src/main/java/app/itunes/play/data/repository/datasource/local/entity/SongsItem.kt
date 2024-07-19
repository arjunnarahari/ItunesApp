package app.itunes.play.data.repository.datasource.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "SongsItem")
data class SongsItem(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: String = "",
    @ColumnInfo(name = "title") var title: String? = "",
    @ColumnInfo(name = "imageUrl") var imageUrl: String? = "",
    @ColumnInfo(name = "artist") var artist: String? = "",
    @ColumnInfo(name = "price") var price: String? = "",
    @ColumnInfo(name = "duration") var duration: String? = "",
    @ColumnInfo(name = "audioLink") var audioLink: String? = "",
    //@ColumnInfo(name = "content") var content: String? = "",
)