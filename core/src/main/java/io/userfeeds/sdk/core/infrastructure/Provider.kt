package io.userfeeds.sdk.core.infrastructure

import kotlin.LazyThreadSafetyMode.NONE

typealias Initializer<T> = () -> T

internal abstract class Provider<T : Any>(initializer: Initializer<T>) {

    private val value by lazy(NONE, initializer)
    var override: Initializer<T>? = null

    fun get() = override?.invoke() ?: value
}
