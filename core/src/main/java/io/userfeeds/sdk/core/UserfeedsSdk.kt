package io.userfeeds.sdk.core

object UserfeedsSdk {

    internal lateinit var apiKey: String

    fun initialize(apiKey: String) {
        this.apiKey = apiKey
    }
}
