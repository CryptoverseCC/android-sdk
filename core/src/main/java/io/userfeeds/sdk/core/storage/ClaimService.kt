package io.userfeeds.sdk.core.storage

import io.reactivex.Completable
import io.userfeeds.sdk.core.context.ShareContext

fun putClaim(
        shareContext: ShareContext,
        type: List<String>,
        target: String,
        labels: List<String>?,
        client: String,
        signature: Signature): Completable {
    val claimWrapper = ClaimWrapper(
            shareContext.id,
            type,
            Claim(target, labels),
            listOf(Credit("interface", client)),
            signature
    )
    return StorageApiProvider.get().call(claimWrapper)
}
