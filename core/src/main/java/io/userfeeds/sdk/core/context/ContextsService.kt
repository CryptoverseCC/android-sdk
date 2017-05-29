package io.userfeeds.sdk.core.context

import io.reactivex.Single
import io.userfeeds.sdk.core.common.map

fun getContexts(): Single<List<ShareContext>> {
    return ContextsApiProvider.get()
            .call()
            .map(::toShareContextList)
}

private fun toShareContextList(contexts: Map<String, ShareContextFromApi>): List<ShareContext> {
    return contexts.map(::toShareContext)
}

private fun toShareContext(id: String, context: ShareContextFromApi): ShareContext {
    return ShareContext(
            id = id,
            hashtag = context.hashtag,
            imageUrl = "https://beta.userfeeds.io/api/contexts${context.images.avatar}"
    )
}
