package io.userfeeds.sdk.core.signing

import io.userfeeds.sdk.core.storage.ClaimWrapper
import io.userfeeds.sdk.core.storage.ClaimSignature

interface ClaimSigner {

    fun sign(claimWrapper: ClaimWrapper, keyPairHex: KeyPairHex): ClaimSignature
}
