package com.myprimer.appproductive.Pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprimer.appproductive.Modelo.TodoViewModel


@Composable
fun Intellectual(modifier: Modifier = Modifier, viewModel: TodoViewModel) {




    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF0000009))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Intellectual Games",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Juego 1: Rompecabezas de palabras
        IntellectualGameItem(
            title = "Word Puzzle",
            description = "¡Encuentra palabras ocultas en una cuadrícula!",
            onClick = {
                // Acción para iniciar este juego
            }
        )

        // Juego 2: Acertijos lógicos
        IntellectualGameItem(
            title = "Logic Puzzles",
            description = "¡Resuelve acertijos lógicos alucinantes!",
            onClick = {
                // Acción para iniciar este juego
            }
        )

        // Juego 3: Cálculos mentales
        IntellectualGameItem(
            title = "Mental Math",
            description = "¡Agudice sus habilidades de cálculo!",
            onClick = {
                // Acción para iniciar este juego
            }
        )
    
        // Juego 4: Ejercicio de memoria
        IntellectualGameItem(
            title = "Memory Test",
            description = "¡Pon a prueba tu memoria con cartas coincidentes!",
            onClick = {
                // Acción para iniciar este juego
            }
        )

        // Juego 4: Ejercicio de memoria
        IntellectualGameItem(
            title = "Add your learned words",
            description = "¡Mejora en el idioma guardando las palabras aprendidas!",
            onClick = {
                // Acción para iniciar este juego
            }
        )

    }

}

@Composable
fun IntellectualGameItem(title: String, description: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.primary)
            .clickable(onClick = onClick)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = description,
            fontSize = 16.sp,
            color = Color.LightGray
        )
    }
}





















