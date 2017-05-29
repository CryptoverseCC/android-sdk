package io.userfeeds.sdk.core.algorithm

import android.os.Parcel
import android.os.Parcelable
import io.userfeeds.sdk.core.common.parcelableCreator

data class Algorithm(
        val identifier: String,
        val description: String)
    :
        Parcelable {

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(identifier)
        dest.writeString(description)
    }

    companion object {

        @JvmField
        val CREATOR = parcelableCreator {
            Algorithm(
                    readString(),
                    readString()
            )
        }
    }
}
