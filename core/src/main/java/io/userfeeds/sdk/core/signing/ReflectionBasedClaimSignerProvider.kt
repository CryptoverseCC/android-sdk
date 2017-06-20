package io.userfeeds.sdk.core.signing

import io.userfeeds.sdk.core.infrastructure.Provider

internal object ReflectionBasedClaimSignerProvider : Provider<ClaimSigner>({
    val clazz = Class.forName("io.userfeeds.sdk.signing.ClaimSignerImpl")
    val instanceField = clazz.getDeclaredField("INSTANCE")
    instanceField.get(null) as ClaimSigner
})
