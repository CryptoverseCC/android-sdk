package io.userfeeds.sdk.core.storage

import io.reactivex.Completable
import io.userfeeds.sdk.core.UserfeedsSdk
import io.userfeeds.sdk.core.context.ShareContext
import io.userfeeds.sdk.core.signing.KeyPairHex

internal fun putClaimImpl(
        shareContext: ShareContext,
        type: List<String>,
        target: String,
        labels: List<String>?,
        client: String,
        keyPairHex: KeyPairHex): Completable {
    val claimSigner = try {
        UserfeedsSdk.claimSignerProvider.get()
    } catch (ex: ClassNotFoundException) {
        throwRequiredSigningModule()
    }
    val claimWrapper = ClaimWrapper(
            shareContext.id,
            type,
            Claim(target, labels),
            listOf(Credit("interface", client))
    )
    val signature = claimSigner.sign(claimWrapper, keyPairHex)
    val signedClaimWrapper = SignedClaimWrapper(
            context = claimWrapper.context,
            type = claimWrapper.type,
            claim = claimWrapper.claim,
            credits = claimWrapper.credits,
            signature = signature
    )
    return StorageApiProvider.get().call(UserfeedsSdk.apiKey, signedClaimWrapper)
}

private fun throwRequiredSigningModule(): Nothing {
    throw Exception("""
            |In order to use UserfeedsService.putClaim(...) you need to add signing dependency:
            |
            |dependencies {
            |    compile 'io.userfeeds.sdk:signing-sc:<latest version here>'
            |}
            """.trimMargin())
}
