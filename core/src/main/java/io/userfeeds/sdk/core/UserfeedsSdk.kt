package io.userfeeds.sdk.core

object UserfeedsSdk {

    internal lateinit var apiKey: String
    internal var debug: Boolean = false

    fun initialize(apiKey: String, debug: Boolean = false) {
        this.apiKey = apiKey
        this.debug = debug
    }
}
