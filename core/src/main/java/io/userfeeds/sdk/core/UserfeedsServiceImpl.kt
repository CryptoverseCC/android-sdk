package io.userfeeds.sdk.core

import io.userfeeds.sdk.core.algorithm.Algorithm
import io.userfeeds.sdk.core.algorithm.getAlgorithmsImpl
import io.userfeeds.sdk.core.ranking.getRankingImpl
import io.userfeeds.sdk.core.storage.ClaimWrapper
import io.userfeeds.sdk.core.storage.Signature
import io.userfeeds.sdk.core.storage.putClaimImpl

internal object UserfeedsServiceImpl : UserfeedsService {

    override fun getAlgorithms(context: RankingContext)
            = getAlgorithmsImpl(context)

    override fun getRanking(context: RankingContext, algorithm: Algorithm, whitelist: String?)
            = getRankingImpl(context, algorithm, whitelist)

    override fun putClaim(claimWrapper: ClaimWrapper, signature: Signature)
            = putClaimImpl(claimWrapper, signature)
}
