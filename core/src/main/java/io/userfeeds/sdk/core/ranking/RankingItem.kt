package io.userfeeds.sdk.core.ranking

import android.os.Parcel
import android.os.Parcelable
import io.userfeeds.sdk.core.common.parcelableCreator
import io.userfeeds.sdk.core.common.readSerializableEx
import java.math.BigDecimal

data class RankingItem(
        val target: String,
        val score: BigDecimal,
        val title: String?,
        val summary: String?)
    :
        Parcelable {

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(target)
        dest.writeSerializable(score)
        dest.writeString(title)
        dest.writeString(summary)
    }

    companion object {

        @JvmField
        val CREATOR = parcelableCreator {
            RankingItem(
                    readString(),
                    readSerializableEx(),
                    readString(),
                    readString()
            )
        }
    }
}
