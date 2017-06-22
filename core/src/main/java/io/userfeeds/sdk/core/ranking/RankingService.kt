package io.userfeeds.sdk.core.ranking

import io.reactivex.Single
import io.userfeeds.sdk.core.algorithm.Algorithm
import io.userfeeds.sdk.core.context.ShareContext

internal fun getRankingImpl(shareContext: ShareContext, algorithm: Algorithm, whitelist: String?): Single<List<RankingItem>> {
    return RankingApiProvider.get()
            .call(shareContext.id, algorithm.identifier, whitelist)
            .map { it.items }
}
