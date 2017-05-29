package io.userfeeds.sdk.core.storage

import io.userfeeds.sdk.core.infrastructure.retrofit.ApiProvider

internal object StorageApiProvider : ApiProvider<StorageApi>(StorageApi::class)
