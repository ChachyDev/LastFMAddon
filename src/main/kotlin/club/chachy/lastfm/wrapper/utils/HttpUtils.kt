package club.chachy.lastfm.wrapper.utils

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

val json = Json {
    isLenient = true
    ignoreUnknownKeys = true
}

inline fun <reified T> get(url: String) = json.decodeFromString<T>(khttp.get(url).text)
