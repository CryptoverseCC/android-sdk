package io.userfeeds.sdk.core.infrastructure.retrofit

import io.userfeeds.sdk.core.infrastructure.Provider
import kotlin.reflect.KClass

internal abstract class ApiProvider<T : Any>(clazz: KClass<T>) : Provider<T>({ RetrofitProvider.get().create(clazz.java) })
