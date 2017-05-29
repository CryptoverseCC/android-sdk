package io.userfeeds.sdk.core.algorithm

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

internal interface AlgorithmsApi {

    @GET("ranking/{context}/")
    fun call(@Path("context") context: String): Single<AlgorithmsResponse>
}
