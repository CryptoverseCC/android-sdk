package io.userfeeds.sdk.core.ranking

import io.reactivex.Single
import io.userfeeds.sdk.core.RankingContext
import io.userfeeds.sdk.core.algorithm.Algorithm

internal fun getRankingImpl(context: RankingContext, algorithm: Algorithm, whitelist: String?): Single<List<RankingItem>> {
    return RankingApiProvider.get()
            .call(context, algorithm.identifier, whitelist)
            .map { it.items }
}
