package io.userfeeds.sdk.core.common

import android.os.Parcel
import java.io.Serializable

internal inline fun <reified T : Serializable> Parcel.readSerializableEx() = readSerializable() as T
