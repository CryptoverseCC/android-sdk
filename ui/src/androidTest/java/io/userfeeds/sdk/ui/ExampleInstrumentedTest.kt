package io.userfeeds.sdk.ui

import android.support.test.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test

class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("io.userfeeds.sdk.ui.test", appContext.packageName)
    }
}
