package io.userfeeds.sdk.core

import io.reactivex.Single
import io.userfeeds.sdk.core.ranking.RankingItem

interface UserfeedsService {

    fun getRanking(
            asset: String,
            recipientAddress: String,
            algorithm: String,
            whitelist: String?): Single<List<RankingItem>>

    companion object {

        fun get(): UserfeedsService = UserfeedsServiceImpl
    }
}
