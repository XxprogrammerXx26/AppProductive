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
//fun Profile(modifier: Modifier = Modifier) {
//    val context = LocalContext.current
//    val auth = FirebaseAuth.getInstance()
//    val googleSignInClient = GoogleSignIn.getClient(context, GoogleSignInOptions.DEFAULT_SIGN_IN)
//
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .padding(horizontal = 24.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = "Configuración",
//            fontSize = 36.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(bottom = 24.dp)
//        )
//
//        Button(
//            onClick = {
//                auth.signOut()
//                googleSignInClient.signOut()
//            },
//            colors = ButtonDefaults.buttonColors(
//   //             backgroundColor = MaterialTheme.colorScheme.secondary
//            ),
//            shape = RoundedCornerShape(8.dp),
//            modifier = Modifier
//                .width(200.dp)
//                .height(48.dp)
//        ) {
//            Text(text = "Cerrar Sesión", color = MaterialTheme.colorScheme.onSecondary)
//        }
//    }
//}


















