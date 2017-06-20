package io.userfeeds.sdk.core

import io.userfeeds.sdk.core.infrastructure.Provider
import io.userfeeds.sdk.core.signing.ClaimSigner
import io.userfeeds.sdk.core.signing.ReflectionBasedClaimSignerProvider

object UserfeedsSdk {

    internal lateinit var apiKey: String
    internal lateinit var claimSignerProvider: Provider<ClaimSigner>
    internal var debug: Boolean = false

    @JvmStatic
    fun initialize(
            apiKey: String,
            claimSignerProvider: Provider<ClaimSigner> = ReflectionBasedClaimSignerProvider,
            debug: Boolean = false) {
        this.apiKey = apiKey
        this.claimSignerProvider = claimSignerProvider
        this.debug = debug
    }
}
