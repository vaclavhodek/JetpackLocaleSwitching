package com.localazy.jetpacklocaleswitching.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.localazy.android.Localazy
import com.localazy.android.LocalazyLocale
import kotlinx.coroutines.launch

class LocaleViewModel : ViewModel() {

    private val localazyListener = LocalazyWrappedListener {
        viewModelScope.launch {
            update()
        }
    }

    var locales by mutableStateOf(listOf<LocalazyLocale>())
        private set

    init {
        Localazy.setListener(localazyListener)
        update()
    }

    private fun update() {
        locales = Localazy.getLocales() ?: emptyList()
    }

}