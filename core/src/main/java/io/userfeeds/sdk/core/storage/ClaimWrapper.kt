package io.userfeeds.sdk.core.storage

import android.content.Intent
import io.userfeeds.sdk.core.RankingContext

data class ClaimWrapper(
        val context: RankingContext,
        val type: List<String>,
        val claim: Claim,
        val credits: List<Credit>) {

    companion object {

        fun create(context: RankingContext, type: List<String>, claim: Claim, clientId: String): ClaimWrapper {
            return ClaimWrapper(context, type, claim, listOf(Credit("interface", clientId)))
        }
    }
}

internal data class SignedClaimWrapper(
        val context: RankingContext,
        val type: List<String>,
        val claim: Claim,
        val credits: List<Credit>,
        val signature: Signature
)

data class Claim(
        val target: String,
        val title: String? = null,
        val summary: String? = null,
        val labels: List<String>? = null
)

data class Credit(val type: String, val value: String)

data class Signature(val type: String, val creator: String, val signatureValue: String) {

    companion object {

        fun fromIntentData(data: Intent): Signature {
            return Signature(
                    type = data.getStringExtra("io.userfeeds.identity.signature.type"),
                    creator = data.getStringExtra("io.userfeeds.identity.signature.creator"),
                    signatureValue = data.getStringExtra("io.userfeeds.identity.signature.value")
            )
        }
    }
}
