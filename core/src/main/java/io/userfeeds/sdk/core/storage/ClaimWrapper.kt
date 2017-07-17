package io.userfeeds.sdk.core.storage

import io.userfeeds.sdk.core.RankingContext

data class ClaimWrapper(
        val context: RankingContext,
        val type: List<String>,
        val claim: Claim,
        val credits: List<Credit>
)

internal data class SignedClaimWrapper(
        val context: RankingContext,
        val type: List<String>,
        val claim: Claim,
        val credits: List<Credit>,
        val signature: ClaimSignature
)

data class Claim(val target: String, val labels: List<String>?)

data class Credit(val type: String, val value: String)

data class ClaimSignature(val type: String, val creator: String, val signatureValue: String)
