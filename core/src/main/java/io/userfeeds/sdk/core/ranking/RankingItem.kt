package io.userfeeds.sdk.core.ranking

import android.os.Parcel
import android.os.Parcelable
import io.userfeeds.sdk.core.common.parcelableCreator

data class RankingItem(
        val target: String,
        val score: Double,
        val title: String)
    :
        Parcelable {

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(target)
        dest.writeDouble(score)
        dest.writeString(title)
    }

    companion object {

        @JvmField
        val CREATOR = parcelableCreator {
            RankingItem(
                    readString(),
                    readDouble(),
                    readString()
            )
        }
    }
}
