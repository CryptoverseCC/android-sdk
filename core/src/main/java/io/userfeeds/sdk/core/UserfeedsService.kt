package io.userfeeds.sdk.core

import io.reactivex.Completable
import io.reactivex.Single
import io.userfeeds.sdk.core.algorithm.Algorithm
import io.userfeeds.sdk.core.ranking.RankingItem
import io.userfeeds.sdk.core.storage.ClaimWrapper
import io.userfeeds.sdk.core.storage.Signature

interface UserfeedsService {

    fun getAlgorithms(context: RankingContext): Single<List<Algorithm>>

    fun getRanking(
            context: RankingContext,
            algorithm: Algorithm,
            whitelist: String?): Single<List<RankingItem>>

    fun putClaim(claimWrapper: ClaimWrapper, signature: Signature): Completable

    companion object {

        fun get(): UserfeedsService = UserfeedsServiceImpl
    }
}
