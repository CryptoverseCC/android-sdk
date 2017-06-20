package io.userfeeds.sdk.core

import io.userfeeds.sdk.core.algorithm.Algorithm
import io.userfeeds.sdk.core.algorithm.getAlgorithmsImpl
import io.userfeeds.sdk.core.context.ShareContext
import io.userfeeds.sdk.core.context.getContextsImpl
import io.userfeeds.sdk.core.ranking.getRankingImpl
import io.userfeeds.sdk.core.signing.KeyPairHex
import io.userfeeds.sdk.core.storage.putClaimImpl

internal object UserfeedsServiceImpl : UserfeedsService {

    override fun getContexts() = getContextsImpl()

    override fun getAlgorithms(shareContext: ShareContext)
            = getAlgorithmsImpl(shareContext)

    override fun getRanking(shareContext: ShareContext, algorithm: Algorithm)
            = getRankingImpl(shareContext, algorithm)

    override fun putClaim(shareContext: ShareContext, type: List<String>, target: String, labels: List<String>?, client: String, keyPairHex: KeyPairHex)
            = putClaimImpl(shareContext, type, target, labels, client, keyPairHex)
}
