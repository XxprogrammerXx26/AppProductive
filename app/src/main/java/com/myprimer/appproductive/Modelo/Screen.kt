package com.myprimer.appproductive.Modelo



sealed class Screen(val route: String) {
    object LoginScreen : Screen("login") // Agrega la ruta para LoginScreen
    object MainScreen : Screen("main_screen")
    object LogicGame : Screen("logicGame")
    object MathGame : Screen("mathGame")
    object LanguageGame : Screen("languageGame")




    // Add other screens as needed
}

