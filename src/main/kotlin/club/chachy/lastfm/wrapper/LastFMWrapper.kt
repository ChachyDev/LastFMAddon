package club.chachy.lastfm.wrapper

import club.chachy.lastfm.wrapper.data.RecentTracksResponse
import club.chachy.lastfm.wrapper.utils.get

class LastFMWrapper(private val key: String) {
    fun getRecentTracks(user: String) =
        get<RecentTracksResponse>("https://ws.audioscrobbler.com/2.0/?method=user.getrecenttracks&user=$user&api_key=$key&format=json")
}