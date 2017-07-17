package io.userfeeds.sdk.core.storage

import io.reactivex.Completable
import io.userfeeds.sdk.core.RankingContext
import io.userfeeds.sdk.core.UserfeedsSdk
import io.userfeeds.sdk.core.signing.KeyPairHex

internal fun putClaimImpl(
        context: RankingContext,
        type: List<String>,
        claim: Claim,
        client: String,
        keyPairHex: KeyPairHex): Completable {
    val claimSigner = try {
        UserfeedsSdk.claimSignerProvider.get()
    } catch (ex: ClassNotFoundException) {
        throwRequiredSigningModule()
    }
    val claimWrapper = ClaimWrapper(
            context = context,
            type = type,
            claim = claim,
            credits = listOf(Credit("interface", client))
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
