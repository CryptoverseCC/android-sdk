package io.userfeeds.sdk.core.algorithm

import io.reactivex.Single
import io.userfeeds.sdk.core.RankingContext
import retrofit2.http.GET
import retrofit2.http.Path

internal interface AlgorithmsApi {

    @GET("ranking/{context}/")
    fun call(@Path("context") context: RankingContext): Single<AlgorithmsResponse>
}
