package io.userfeeds.sdk.core.storage

import io.reactivex.Completable
import io.userfeeds.sdk.core.RankingContext
import io.userfeeds.sdk.core.UserfeedsSdk

internal fun putClaimImpl(
        context: RankingContext,
        type: List<String>,
        claim: Claim,
        signature: Signature,
        client: String): Completable {
    val signedClaimWrapper = SignedClaimWrapper(
            context = context,
            type = type,
            claim = claim,
            credits = listOf(Credit("interface", client)),
            signature = signature
    )
    return StorageApiProvider.get().call(UserfeedsSdk.apiKey, signedClaimWrapper)
}
