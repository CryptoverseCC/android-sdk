package io.userfeeds.sdk.core.storage

internal data class ClaimWrapper(
        val context: String,
        val type: List<String>,
        val claim: Claim,
        val credits: List<Credit>,
        val signature: Signature
)

internal data class Claim(val target: String, val labels: List<String>?)

internal data class Credit(val type: String, val value: String)

data class Signature(val type: String, val creator: String, val signatureValue: String)
