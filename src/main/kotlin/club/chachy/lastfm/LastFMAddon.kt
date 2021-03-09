package club.chachy.lastfm

import com.mediamod.core.addon.MediaModAddon
import com.mediamod.core.service.MediaModServiceRegistry

@Suppress("unused") // I HATE THIS
class LastFMAddon : MediaModAddon("lastfm-addon") {

    override fun initialise() {
        MediaModServiceRegistry.registerService(identifier, LastFMService())
        println("Successfully loaded LastFM Service")
    }
}