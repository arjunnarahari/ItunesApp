package app.itunes.play.data.model

import android.os.Parcelable
import com.tickaroo.tikxml.annotation.*
import com.tickaroo.tikxml.converter.htmlescape.HtmlEscapeStringConverter
import kotlinx.parcelize.Parcelize

@Xml(name = "feed")
data class Feed(
    @PropertyElement(name = "id") val id: String?,
    @PropertyElement(name = "title") val title: String?,
    @Element(name = "author") val author: Author?,
    @Element(name = "entry") val entryList: List<Entry>?
)

@Xml(name = "author")
data class Author(
    @PropertyElement(name = "name") val name: String?,
    @PropertyElement(name = "uri") val uri: String?
)

@Parcelize
@Xml(name = "entry", writeNamespaces = ["im=itunes.apple.com/rss"])
data class Entry(
    @PropertyElement(name = "id") val id: String?,
    @PropertyElement(
        name = "title",
        converter = HtmlEscapeStringConverter::class
    ) val title: String?,
    @PropertyElement(name = "im:image") val imageUrl: String?,
    @PropertyElement(name = "im:artist", converter = HtmlEscapeStringConverter::class ) val artist: String?,
    @PropertyElement(name = "im:price") val price: String?,
//    @PropertyElement(
//        name = "content",
//        converter = HtmlEscapeStringConverter::class
//    ) val content: String,
    @Element val link: Link,
    //@Element val category: Category
) : Parcelable

@Parcelize
@Xml(name = "category")
data class Category(
    @Attribute(name = "label") val label: String?
) : Parcelable

@Parcelize
@Xml(name = "link", writeNamespaces = ["im=itunes.apple.com/rss"])
data class Link(
    @PropertyElement(name = "im:duration") val duration: String?="",
    @Attribute(name = "type") val type: String?="",
    @Attribute(name = "href") val audioLink: String?=""
) : Parcelable

