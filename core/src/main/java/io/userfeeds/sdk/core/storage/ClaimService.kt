package io.userfeeds.sdk.core.storage

import io.reactivex.Completable
import io.userfeeds.sdk.core.UserfeedsSdk

internal fun putClaimImpl(claimWrapper: ClaimWrapper, signature: Signature): Completable {
    val signedClaimWrapper = SignedClaimWrapper(
            context = claimWrapper.context,
            type = claimWrapper.type,
            claim = claimWrapper.claim,
            credits = claimWrapper.credits,
            signature = signature
    )
    return StorageApiProvider.get().call(UserfeedsSdk.apiKey, signedClaimWrapper)
}
