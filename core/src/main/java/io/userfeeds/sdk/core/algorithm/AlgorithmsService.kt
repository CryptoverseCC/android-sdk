package io.userfeeds.sdk.core.algorithm

import io.reactivex.Single
import io.userfeeds.sdk.core.context.ShareContext

internal fun getAlgorithmsImpl(shareContext: ShareContext): Single<List<Algorithm>> {
    return AlgorithmsApiProvider.get()
            .call(shareContext.id)
            .map { it.items }
}
