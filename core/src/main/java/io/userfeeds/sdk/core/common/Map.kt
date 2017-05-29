package io.userfeeds.sdk.core.common

internal inline fun <K, V, R> Map<K, V>.map(transform: (K, V) -> R): List<R> {
    return map { (k, v) -> transform(k, v) }
}
