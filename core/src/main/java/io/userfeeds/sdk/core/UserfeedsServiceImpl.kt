package io.userfeeds.sdk.core

import io.userfeeds.sdk.core.ranking.getRankingImpl

internal object UserfeedsServiceImpl : UserfeedsService {

    override fun getRanking(asset: String, recipientAddress: String, algorithm: String, whitelist: String?)
            = getRankingImpl(asset, recipientAddress, algorithm, whitelist)
}
