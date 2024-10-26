package com.myprimer.appproductive.Pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprimer.appproductive.Modelo.TodoViewModel
import com.myprimer.appproductive.R




@Composable
fun Intellectual(modifier: Modifier = Modifier, viewModel: TodoViewModel ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF1CB5E0))  // Fondo negro sin transparencia
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Juego 1: Acertijos lógicos
        IntellectualGameItem(
            imageRes = R.drawable.puzzles2,
            description = "¡Resuelve acertijos lógicos y desafiantes!",
            onClick = {
                // Acción para iniciar este juego
            }
        )

        // Juego 2: Cálculos mentales
        IntellectualGameItem(
            imageRes = R.drawable.math1,
            description = "¡Desafía tu mente y agudiza tus habilidades de cálculo!",
            onClick = {
                // Acción para iniciar este juego
            }
        )

        // Juego 3: Agregar palabras aprendidas
        IntellectualGameItem(
            imageRes = R.drawable.idiomas,
            description ="¡Domina el idioma La repetición espaciada te ayudará a retenerlas para siempre!",
            onClick = {

            }
        )
    }
}

@Composable
fun IntellectualGameItem(imageRes: Int, description: String, onClick:  () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))  // Bordes suaves
            .background(MaterialTheme.colorScheme.primary)
            .clickable(onClick = onClick)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()  // Llenar el ancho disponible
                .height(150.dp)  // Altura fija para todas las imágenes
                .padding(bottom = 8.dp),
            contentScale = ContentScale.Fit  // Ajustar la imagen para que se vea completa sin recortes
        )
        Text(
            text = description,
            fontSize = 14.sp,  // Tamaño del texto ajustado
            color = Color.Yellow
        )
    }
}













