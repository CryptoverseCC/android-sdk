package io.userfeeds.sdk.signing

import io.userfeeds.sdk.core.infrastructure.Provider
import io.userfeeds.sdk.core.signing.ClaimSigner

object ClaimSignerProvider : Provider<ClaimSigner>({ ClaimSignerImpl })
