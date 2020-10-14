package com.localazy.jetpacklocaleswitching

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.localazy.android.Localazy
import com.localazy.jetpacklocaleswitching.data.LocaleViewModel
import com.localazy.jetpacklocaleswitching.ui.LocaleSwitcher

class SwitchActivity : AppCompatActivity() {

    private val localeViewModel by viewModels<LocaleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocaleSwitcher(
                items = localeViewModel.locales,
                onChange = {

                    // Change the locale and persist the new choice.
                    Localazy.forceLocale(it.locale, true)

                    // Reopen MainActivity with clearing top.
                    startActivity(
                        Intent(
                            this@SwitchActivity,
                            MainActivity::class.java
                        ).apply {
                            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        }
                    )

                },
                onHelp = {
                    // Open the project on Localazy to allow contributors to help us with translating.
                    startActivity(
                        Intent(Intent.ACTION_VIEW, Localazy.getProjectUri()).apply {
                            flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        }
                    )
                }
            )
        }
    }

}