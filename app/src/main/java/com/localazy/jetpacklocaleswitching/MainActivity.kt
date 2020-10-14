package com.localazy.jetpacklocaleswitching

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.foundation.Icon
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Translate
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import com.localazy.jetpacklocaleswitching.ui.WelcomeText

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            startActivity(
                                Intent(this@MainActivity, SwitchActivity::class.java)
                            )
                        },
                        elevation = 10.dp
                    ) {
                        Icon(Icons.Default.Translate)
                    }
                },
                bodyContent = {
                    WelcomeText(text = getString(R.string.welcome_message))
                }
            )
        }
    }

}