package com.myprimer.appproductive


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
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
import androidx.navigation.compose.rememberNavController
import com.myprimer.appproductive.Modelo.NavItem
import com.myprimer.appproductive.Modelo.TodoViewModel
import com.myprimer.appproductive.Pages.Home
import com.myprimer.appproductive.Pages.Intellectual
import com.myprimer.appproductive.Pages.Productive





@Composable
fun MainScreen(modifier: Modifier = Modifier, todoViewModel: TodoViewModel) {

    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Productive", Icons.Default.CheckCircle),
        NavItem("Intellectual", Icons.Default.Person),
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
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(imageVector = navItem.icon, contentDescription = "icon")
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex, todoViewModel)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int, todoViewModel: TodoViewModel) {
    when (selectedIndex) {
        0 -> Home()                                                    //Raiz
        1 -> {

            Productive(modifier = modifier, viewModel = todoViewModel)  //Add Rute
        }
        2 -> Intellectual(modifier = modifier, viewModel = todoViewModel)

 //       3 -> Profile(modifier = modifier, viewModel =todoViewModel )
    }
}









































