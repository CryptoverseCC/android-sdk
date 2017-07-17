package io.userfeeds.sdk.core.algorithm

import io.reactivex.Single
import io.userfeeds.sdk.core.RankingContext

internal fun getAlgorithmsImpl(context: RankingContext): Single<List<Algorithm>> {
    return AlgorithmsApiProvider.get()
            .call(context)
            .map { it.items }
}
