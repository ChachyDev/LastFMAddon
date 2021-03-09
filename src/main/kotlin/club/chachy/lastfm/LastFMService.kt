package club.chachy.lastfm

import club.chachy.lastfm.wrapper.LastFMWrapper
import club.chachy.lastfm.wrapper.data.RecentTracksResponse
import com.mediamod.core.service.MediaModService
import com.mediamod.core.track.TrackMetadata

class LastFMService : MediaModService("lastfm") {
    private var track: RecentTracksResponse.RecentTracks.Track? = null
    private val wrapper = LastFMWrapper("b25b959554ed76058ac220b7b2e0a026") // LastFM Example token its ok guys

    override fun fetchTrackMetadata() = TrackMetadata(
        track?.name ?: "Unknown Song",
        track?.artist?.text ?: "Unknown Artist",
        albumArtUrl = track?.image?.getOrNull(2)?.text
    )

    override fun hasTrackMetadata(): Boolean {
        track = runCatching {
            wrapper.getRecentTracks("") // Currently no way to fetch username
                .recentTracks
                ?.tracks
                ?.firstOrNull { it?.attr?.isNowPlaying?.toBoolean() ?: false }
        }.getOrNull()

        return track != null
    }

    override fun initialise() {
        println("Successfully initialised LastFM Service")
    }
}
