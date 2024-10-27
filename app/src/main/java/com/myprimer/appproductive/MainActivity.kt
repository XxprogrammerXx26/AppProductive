package com.myprimer.appproductive


import android.os.Bundle

import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.myprimer.appproductive.Modelo.Screen

import com.myprimer.appproductive.Pages.LanguageGameScreen
import com.myprimer.appproductive.Pages.LogicGameScreen
import com.myprimer.appproductive.Pages.MathGameScreen
import com.myprimer.appproductive.ui.theme.AppProductiveTheme



import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.myprimer.appproductive.Modelo.TodoViewModel


//class MainActivity : ComponentActivity() {
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]
//
//
//        enableEdgeToEdge()
//        setContent {
//            AppProductiveTheme {
//                val navController = rememberNavController() // Crear NavController
//                MainScreen(
//                    navController = navController,
//                    todoViewModel = todoViewModel
//                )   //This part it's for Home Important
//
//
//                // Configura la navegación con NavHost
//                NavHost(navController, startDestination = "home") {
//                    composable("home") { MainScreen(navController, todoViewModel) }
//                    composable(Screen.LogicGame.route) { LogicGameScreen(todoViewModel) }
//                    composable(Screen.MathGame.route) { MathGameScreen(todoViewModel) }
//                    composable(Screen.LanguageGame.route) { LanguageGameScreen(todoViewModel) }
//                    // Agrega otras rutas de composables según sea necesario
//
//                }
//            }
//        }
//    }
//}





class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Obtener el ViewModel
        val todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            AppProductiveTheme {
                // Crear NavController
                val navController = rememberNavController()

                // Configura la navegación con NavHost
                NavHost(navController, startDestination = "home") {
                    composable("home") {
                        MainScreen(navController = navController, todoViewModel = todoViewModel)
                    }
                    composable(Screen.LogicGame.route) {
                        LogicGameScreen(todoViewModel)
                    }
                    composable(Screen.MathGame.route) {
                        MathGameScreen(todoViewModel)
                    }
                    composable(Screen.LanguageGame.route) {
                        LanguageGameScreen(todoViewModel)
                    }

                }
            }
        }
    }
}








