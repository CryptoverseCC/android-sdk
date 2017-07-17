package io.userfeeds.sdk.core.storage

import io.reactivex.Completable
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

internal interface StorageApi {

    @POST("storage/")
    fun call(@Header("Authorization") apiKey: String, @Body body: SignedClaimWrapper): Completable
}
