package io.userfeeds.sdk.signing

import com.squareup.moshi.Moshi
import io.userfeeds.sdk.core.signing.KeyPairHex
import io.userfeeds.sdk.core.signing.ClaimSigner
import io.userfeeds.sdk.core.storage.ClaimSignature
import io.userfeeds.sdk.core.storage.ClaimWrapper
import java.security.KeyFactory
import java.security.Signature
import java.security.spec.PKCS8EncodedKeySpec
import kotlin.text.Charsets.UTF_8

internal object ClaimSignerImpl : ClaimSigner {

    override fun sign(claimWrapper: ClaimWrapper, keyPairHex: KeyPairHex): ClaimSignature {
        val keyFactory = KeyFactory.getInstance("EC")
        val privateKey = keyFactory.generatePrivate(PKCS8EncodedKeySpec(byteArrayFromHexString(keyPairHex.privateKey)))
        val signature = Signature.getInstance("SHA256WithECDSA")
        signature.initSign(privateKey)
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(ClaimWrapper::class.java)
        val claimWrapperJson = adapter.toJson(claimWrapper)
        val claimWrapperByteArray = claimWrapperJson.toByteArray(UTF_8)
        signature.update(claimWrapperByteArray)
        val signatureByteArray = signature.sign()
        val signatureHex = signatureByteArray.toHexString()
        return ClaimSignature(
                type = "ecdsa.prime256v1",
                creator = keyPairHex.publicKey,
                signatureValue = signatureHex
        )
    }
}
