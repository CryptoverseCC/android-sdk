package io.userfeeds.sdk.core

import io.reactivex.Completable
import io.reactivex.Single
import io.userfeeds.sdk.core.algorithm.Algorithm
import io.userfeeds.sdk.core.context.ShareContext
import io.userfeeds.sdk.core.ranking.RankingItem
import io.userfeeds.sdk.core.signing.KeyPairHex

interface UserfeedsService {

    fun getContexts(): Single<List<ShareContext>>

    fun getAlgorithms(shareContext: ShareContext): Single<List<Algorithm>>

    fun getRanking(
            shareContext: ShareContext,
            algorithm: Algorithm,
            whitelist: String?): Single<List<RankingItem>>

    fun putClaim(
            shareContext: ShareContext,
            type: List<String>,
            target: String,
            labels: List<String>?,
            client: String,
            keyPairHex: KeyPairHex): Completable

    companion object {

        fun get(): UserfeedsService = UserfeedsServiceImpl
    }
}
