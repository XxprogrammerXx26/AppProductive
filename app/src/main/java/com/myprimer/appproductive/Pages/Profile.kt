package com.myprimer.appproductive.Pages

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprimer.appproductive.Modelo.TodoViewModel
import com.myprimer.appproductive.R
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

//
//@Composable
//fun Profile(modifier: Modifier = Modifier, viewModel: TodoViewModel) {
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .background(Color(0xFF0000009)),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = "Profile",
//            fontSize = 40.sp,
//            fontWeight = FontWeight.SemiBold,
//            color = Color.White
//        )
//
//        // Estado para la imagen de perfil
//        var imageUri by remember { mutableStateOf<Uri?>(null) }
//
//        // Botón para cambiar la imagen
//        Button(onClick = {
//            // Aquí iría el código para abrir el selector de imágenes
//            // y actualizar imageUri. Este es un ejemplo.
//            // imageUri = ... // Actualizar con la nueva URI
//        }) {
//            Text(text = "Cambiar Imagen de Perfil", color = Color.Black)
//        }
//
//        // Mostrar la imagen de perfil si existe
////        imageUri?.let {
////            Image(
////                painter = rememberImagePainter(it),
////                contentDescription = "Profile Image",
////                modifier = Modifier
////                    .size(128.dp)
////                    .clip(CircleShape)
////                    .border(2.dp, Color.White, CircleShape) // Borde blanco alrededor de la imagen
////            )
////        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Botón para cerrar sesión
//        Button(onClick = {
//            // Lógica para cerrar sesión, por ejemplo:
//            // viewModel.logout()
//        }) {
//            Text(text = "Cerrar Sesión", color = Color.Black)
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Botón para borrar usuario
//        Button(onClick = {
//            // Lógica para confirmar y borrar el usuario, por ejemplo:
//            // viewModel.deleteUser()
//        }) {
//            Text(text = "Borrar Usuario", color = Color.Red)
//        }
//    }
//}






































import android.content.Intent


//@Composable
//fun Profile(modifier: Modifier = Modifier, viewModel: TodoViewModel) {
//    val context = LocalContext.current
//    val auth = FirebaseAuth.getInstance()
//    var user by remember { mutableStateOf(auth.currentUser) }
//
//    // Configuración de Google Sign-In
//    val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//        .requestIdToken("YOUR_WEB_CLIENT_ID")  // Reemplaza con tu ID de cliente de Firebase
//        .requestEmail()
//        .build()
//    val googleSignInClient: GoogleSignInClient = GoogleSignIn.getClient(context, googleSignInOptions)
//
//    // Launcher para la actividad de inicio de sesión de Google
//    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//        if (task.isSuccessful) {
//            val account = task.result
//            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
//            auth.signInWithCredential(credential).addOnCompleteListener { authTask ->
//                if (authTask.isSuccessful) {
//                    user = auth.currentUser
//                }
//            }
//        }
//    }
//
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .background(
//                brush = Brush.verticalGradient(
//                    colors = listOf(Color(0xFF283593), Color(0xFF1E88E5))
//                )
//            )
//            .padding(horizontal = 24.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = "Profile",
//            fontSize = 36.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.White,
//            modifier = Modifier.padding(bottom = 24.dp)
//        )
//
//        user?.let {
//            // Mostrar información del usuario autenticado
//            Text(
//                text = "Bienvenido, ${user.displayName}",
//                color = Color.White,
//                fontSize = 24.sp,
//                modifier = Modifier.padding(16.dp)
//            )
//            // Imagen de perfil del usuario
//            user.photoUrl?.let { photoUri ->
//                Image(
//                    painter = rememberImagePainter(photoUri),
//                    contentDescription = "Profile Image",
//                    modifier = Modifier
//                        .size(128.dp)
//                        .clip(CircleShape)
//                        .border(2.dp, Color.White, CircleShape)
//                )
//            }
//
//            Spacer(modifier = Modifier.height(24.dp))
//
//            // Botón para cerrar sesión
//            Button(
//                onClick = {
//                    auth.signOut()
//                    googleSignInClient.signOut()
//                    user = null
//                },
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = MaterialTheme.colorScheme.secondary
//                ),
//                shape = RoundedCornerShape(8.dp),
//                modifier = Modifier
//                    .width(200.dp)
//                    .height(48.dp)
//            ) {
//                Text(text = "Cerrar Sesión", color = MaterialTheme.colorScheme.onSecondary)
//            }
//        } ?: run {
//            // Botón para iniciar sesión con Google
//            Button(
//                onClick = {
//                    val signInIntent = googleSignInClient.signInIntent
//                    launcher.launch(signInIntent)
//                },
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = MaterialTheme.colorScheme.primaryContainer
//                ),
//                shape = RoundedCornerShape(8.dp),
//                modifier = Modifier
//                    .width(200.dp)
//                    .height(48.dp)
//            ) {
//                Text(text = "Iniciar sesión con Google", color = MaterialTheme.colorScheme.onPrimaryContainer)
//            }
//        }
//    }
//}



















