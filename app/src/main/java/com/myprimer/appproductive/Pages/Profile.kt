package com.myprimer.appproductive.Pages

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprimer.appproductive.Modelo.TodoViewModel


//@Composable
//fun Profile (modifier: Modifier = Modifier, viewModel: TodoViewModel){
//    Column(
//        modifier = modifier.fillMaxSize()
//            .background(Color(0xFF000000)),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment =  Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = "Profile ",
//            fontSize = 40.sp,
//            fontWeight = FontWeight.SemiBold,
//            color = Color.White
//        )
//
//    }
//}













@Composable
fun Profile(modifier: Modifier = Modifier, viewModel: TodoViewModel) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF0000009)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Profile",
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        // Estado para la imagen de perfil
        var imageUri by remember { mutableStateOf<Uri?>(null) }

        // Botón para cambiar la imagen
        Button(onClick = {
            // Aquí iría el código para abrir el selector de imágenes
            // y actualizar imageUri. Este es un ejemplo.
            // imageUri = ... // Actualizar con la nueva URI
        }) {
            Text(text = "Cambiar Imagen de Perfil", color = Color.Black)
        }

        // Mostrar la imagen de perfil si existe
//        imageUri?.let {
//            Image(
//                painter = rememberImagePainter(it),
//                contentDescription = "Profile Image",
//                modifier = Modifier
//                    .size(128.dp)
//                    .clip(CircleShape)
//                    .border(2.dp, Color.White, CircleShape) // Borde blanco alrededor de la imagen
//            )
//        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para cerrar sesión
        Button(onClick = {
            // Lógica para cerrar sesión, por ejemplo:
            // viewModel.logout()
        }) {
            Text(text = "Cerrar Sesión", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para borrar usuario
        Button(onClick = {
            // Lógica para confirmar y borrar el usuario, por ejemplo:
            // viewModel.deleteUser()
        }) {
            Text(text = "Borrar Usuario", color = Color.Red)
        }
    }
}














