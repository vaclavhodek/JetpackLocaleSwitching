package com.localazy.jetpacklocaleswitching.data

import com.localazy.android.LocalazyId
import com.localazy.android.LocalazyListener
import java.util.*

/**
 * A simple class to wrap LocalazyListener, so we don't need to implement
 * all functions, and can use a lambda to monitor changes.
 */
class LocalazyWrappedListener(val body: () -> Unit) : LocalazyListener {

    override fun missingTextFound(p0: LocalazyId?, p1: Locale?, p2: String?) {}

    override fun missingKeyFound(p0: Locale?, p1: String?) {}

    override fun stringsUpdateStarted() {}

    /**
     * This function is called when updated data is downloaded.
     */
    override fun stringsUpdateFinished() {
        body()
    }

    override fun stringsUpdateFailed(p0: Int) {}

    override fun stringsUpdateNotNecessary() {}

    /**
     * This function is called when the strings are loaded.
     */
    override fun stringsLoaded(fromUpdate: Boolean, success: Boolean) {
        if (success) {
            body()
        }
    }

}