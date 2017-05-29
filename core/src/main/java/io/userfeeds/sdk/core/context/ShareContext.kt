package io.userfeeds.sdk.core.context

import android.os.Parcel
import android.os.Parcelable
import io.userfeeds.sdk.core.common.parcelableCreator

data class ShareContext(
        val id: String,
        val hashtag: String,
        val imageUrl: String)
    :
        Parcelable {

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(hashtag)
        dest.writeString(imageUrl)
    }

    companion object {

        @JvmField
        val CREATOR = parcelableCreator {
            ShareContext(
                    readString(),
                    readString(),
                    readString()
            )
        }
    }
}