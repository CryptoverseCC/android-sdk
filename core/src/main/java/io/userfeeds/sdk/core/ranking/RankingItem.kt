package io.userfeeds.sdk.core.ranking

import android.os.Parcel
import android.os.Parcelable
import io.userfeeds.sdk.core.common.parcelableCreator

data class RankingItem(
        val score: Double,
        val value: String)
    :
        Parcelable {

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeDouble(score)
        dest.writeString(value)
    }

    companion object {

        @JvmField
        val CREATOR = parcelableCreator {
            RankingItem(
                    readDouble(),
                    readString()
            )
        }
    }
}
