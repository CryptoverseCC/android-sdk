package io.userfeeds.sdk.core.context

import io.userfeeds.sdk.core.infrastructure.retrofit.ApiProvider

internal object ContextsApiProvider : ApiProvider<ContextsApi>(ContextsApi::class)
