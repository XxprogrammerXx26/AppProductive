package com.myprimer.appproductive.Pages

import android.app.Activity
import android.util.Log


import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider


import com.myprimer.appproductive.Modelo.Screen


import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.test.hasText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.myprimer.appproductive.Modelo.LoginScreenViewModel
import com.myprimer.appproductive.R
import org.w3c.dom.Text


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

) {

    val token ="630199178858-80o8uclu4t1hd6nija4t6fdbla5jrib4.apps.googleusercontent.com"
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()

    ) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
        try {
            val account = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            viewModel.signInWithGoogleCredential(credential) {
                navController.navigate(Screen.MainScreen.route)
            }
        } catch (ex: Exception) {
            Log.d("Usuario", "GoogleSignIn fallo")

        }
    }



    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                val opciones = GoogleSignInOptions.Builder(
                    GoogleSignInOptions.DEFAULT_SIGN_IN
                )
                    .requestIdToken(token)
                    .requestEmail()
                    .build()
                val googleSignInCliente = GoogleSignIn.getClient(context,opciones)
                launcher.launch(googleSignInCliente.signInIntent)
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.google) ,
            contentDescription ="Login con Google" ,
            modifier = Modifier
                .padding(10.dp)
                .size(40.dp)
        )
        Text(text ="Login con Google",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

    }



}


































//
//@Composable
//fun LoginScreen(
//    navController: NavController,
//    viewModel: LoginScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
//) {
//    val token = "630199178858-80o8uclu4t1hd6nija4t6fdbla5jrib4.apps.googleusercontent.com"
//    val context = LocalContext.current
//
//    val launcher = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.StartActivityForResult()
//    ) { result ->
//        if (result.resultCode == Activity.RESULT_OK) {
//            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//            try {
//                val account = task.getResult(ApiException::class.java)
//                val credential = GoogleAuthProvider.getCredential(account.idToken, null)
//                viewModel.signInWithGoogleCredential(credential) {
//                    navController.navigate(Screen.MainScreen.route)
//                }
//            } catch (ex: ApiException) {
//                Log.d("Usuario", "GoogleSignIn fallo: ${ex.localizedMessage}")
//            }
//        } else {
//            Log.d("Usuario", "GoogleSignIn cancelado o fallido")
//        }
//    }
//
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp)
//            .clip(RoundedCornerShape(10.dp))
//            .clickable {
//                val opciones = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                    .requestIdToken(token)
//                    .requestEmail()
//                    .build()
//                val googleSignInCliente = GoogleSignIn.getClient(context, opciones)
//                launcher.launch(googleSignInCliente.signInIntent)
//            },
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Center
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.google),
//            contentDescription = "Login con Google",
//            modifier = Modifier
//                .padding(10.dp)
//                .size(40.dp)
//        )
//        Text(
//            text = "Login con Google",
//            fontSize = 18.sp,
//            fontWeight = FontWeight.Bold
//        )
//    }
//}











