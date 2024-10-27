package com.myprimer.appproductive


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.myprimer.appproductive.Modelo.NavItem
import com.myprimer.appproductive.Modelo.TodoViewModel
import com.myprimer.appproductive.Pages.Home
import com.myprimer.appproductive.Pages.Intellectual
import com.myprimer.appproductive.Pages.IntellectualGameItem
import com.myprimer.appproductive.Pages.LanguageGameScreen
import com.myprimer.appproductive.Pages.LogicGameScreen
import com.myprimer.appproductive.Pages.MathGameScreen


import com.myprimer.appproductive.Pages.Productive


//
//@Composable
//fun MainScreen(navController: NavController,  modifier: Modifier = Modifier, todoViewModel: TodoViewModel) {
//
//    val navItemList = listOf(
//        NavItem("Home", Icons.Default.Home),
//        NavItem("Productive", Icons.Default.CheckCircle),
//        NavItem("Intellectual", Icons.Default.Person),
//        NavItem("Profile", Icons.Default.AccountCircle),
//    )
//
//    var selectedIndex by remember {
//        mutableIntStateOf(0)
//    }
//
//    Scaffold(
//        modifier = Modifier.fillMaxSize(),
//        bottomBar = {
//            NavigationBar {
//                navItemList.forEachIndexed { index, navItem ->
//                    NavigationBarItem(
//                        selected = selectedIndex == index,
//                        onClick = {
//                            selectedIndex = index
//                        },
//                        icon = {
//                            Icon(imageVector = navItem.icon, contentDescription = "icon")
//                        },
//                        label = {
//                            Text(text = navItem.label)
//                        }
//                    )
//                }
//            }
//        }
//    ) { innerPadding ->
//        ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex, todoViewModel)
//    }
//}
//
//
//
//@Composable
//fun ContentScreen(navController: NavController,    modifier: Modifier = Modifier, selectedIndex: Int, todoViewModel: TodoViewModel) {
//    when (selectedIndex) {
//
//
//        0 -> Home()                                                    //Raiz
//        1 -> {
//            Productive(modifier = modifier, viewModel = todoViewModel)  //Add Rute
//        }
//        2 -> Intellectual(navController =navController, modifier = modifier, viewModel = todoViewModel)
//
//     //   3 -> Profile(modifier = modifier )
//
//
//    }
//}






























































@Composable
fun MainScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    todoViewModel: TodoViewModel
) {
    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Productive", Icons.Default.CheckCircle),
        NavItem("Intellectual", Icons.Default.Person),
//        NavItem("Language Game", Icons.Default.Language), // New Item
//        NavItem("Logic Game", Icons.Default.Help), // New Item
//        NavItem("Math Game", Icons.Default.Calculate), // New Item
        NavItem("Profile", Icons.Default.AccountCircle),
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = { Icon(imageVector = navItem.icon, contentDescription = "icon") },
                        label = { Text(text = navItem.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            selectedIndex = selectedIndex,
            todoViewModel = todoViewModel
        )
    }
}

@Composable
fun ContentScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    todoViewModel: TodoViewModel
) {
    when (selectedIndex) {
        0 -> Home()
        1 -> Productive(modifier = modifier, viewModel = todoViewModel)
        2 -> Intellectual(navController = navController, modifier = modifier, viewModel = todoViewModel)
        // 3 -> Profile(modifier = modifier)

//        3 -> LanguageGameScreen(viewModel = todoViewModel) // Implemented here
//        4 -> LogicGameScreen(viewModel = todoViewModel) // Implemented here
//        5 -> MathGameScreen(viewModel = todoViewModel) // Implemented here
    }
}






