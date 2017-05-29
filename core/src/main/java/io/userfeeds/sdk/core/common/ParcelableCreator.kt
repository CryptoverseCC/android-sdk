package io.userfeeds.sdk.core.common

import android.os.Parcel
import android.os.Parcelable

internal inline fun <reified T : Parcelable> parcelableCreator(crossinline createObject: Parcel.() -> T) = object : Parcelable.Creator<T> {

    override fun createFromParcel(source: Parcel) = source.createObject()

    override fun newArray(size: Int) = arrayOfNulls<T>(size)
}
