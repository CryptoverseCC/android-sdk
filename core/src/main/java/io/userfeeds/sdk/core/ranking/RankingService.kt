package io.userfeeds.sdk.core.ranking

import io.reactivex.Single

internal fun getRankingImpl(
        asset: String,
        recipientAddress: String,
        algorithm: String,
        whitelist: String?): Single<List<RankingItem>> {
    return RankingApiProvider.get()
            .call(asset, recipientAddress, algorithm, whitelist)
            .map { it.items }
}
