package io.userfeeds.sdk.core.context

import android.os.Parcel
import android.os.Parcelable

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
        val CREATOR = object : Parcelable.Creator<ShareContext> {

            override fun createFromParcel(source: Parcel) = ShareContext(
                    source.readString(),
                    source.readString(),
                    source.readString()
            )

            override fun newArray(size: Int) = arrayOfNulls<ShareContext>(size)
        }
    }
}
