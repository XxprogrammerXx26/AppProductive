package com.myprimer.appproductive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.myprimer.appproductive.Modelo.TodoViewModel
import com.myprimer.appproductive.ui.theme.AppProductiveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            AppProductiveTheme {
            MainScreen(todoViewModel = todoViewModel)   //This part it's for Home Important

            }
        }
    }
}




