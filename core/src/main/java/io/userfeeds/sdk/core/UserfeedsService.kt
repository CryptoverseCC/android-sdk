package io.userfeeds.sdk.core

import io.reactivex.Completable
import io.reactivex.Single
import io.userfeeds.sdk.core.algorithm.Algorithm
import io.userfeeds.sdk.core.ranking.RankingItem
import io.userfeeds.sdk.core.signing.KeyPairHex
import io.userfeeds.sdk.core.storage.Claim

interface UserfeedsService {

    fun getAlgorithms(context: RankingContext): Single<List<Algorithm>>

    fun getRanking(
            context: RankingContext,
            algorithm: Algorithm,
            whitelist: String?): Single<List<RankingItem>>

    fun putClaim(
            context: RankingContext,
            type: List<String>,
            claim: Claim,
            client: String,
            keyPairHex: KeyPairHex): Completable

    companion object {

        fun get(): UserfeedsService = UserfeedsServiceImpl
    }
}
