package club.chachy.lastfm.wrapper.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecentTracksResponse(@SerialName("recenttracks") val recentTracks: RecentTracks?) {
    @Serializable
    data class RecentTracks(
        @SerialName("track")
        val tracks: List<Track?>?
    ) {
        @Serializable
        data class Track(
            @SerialName("artist")
            val artist: Artist?,
            @SerialName("@attr")
            val attr: Attr? = null,
            @SerialName("image")
            val image: List<Image?>?,
            @SerialName("name")
            val name: String?,
        ) {

            @Serializable
            data class Artist(
                @SerialName("#text")
                val text: String?
            )

            @Serializable
            data class Attr(
                @SerialName("nowplaying")
                val isNowPlaying: String?
            )

            @Serializable
            data class Image(
                @SerialName("size")
                val size: String?,
                @SerialName("#text")
                val text: String?
            )
        }
    }
}