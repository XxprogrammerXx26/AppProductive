package com.myprimer.appproductive.Modelo



sealed class Screen(val route: String) {
    object LogicGame : Screen("logicGame")
    object MathGame : Screen("mathGame")
    object LanguageGame : Screen("languageGame")
    // Add other screens as needed




}

