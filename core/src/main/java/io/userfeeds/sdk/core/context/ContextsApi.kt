package io.userfeeds.sdk.core.context

import io.reactivex.Single
import retrofit2.http.GET

internal interface ContextsApi {

    @GET("contexts")
    fun call(): Single<Map<String, ShareContextFromApi>>
}
