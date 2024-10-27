package com.myprimer.appproductive.Pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprimer.appproductive.Modelo.TodoViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier



@Composable
fun MathGameScreen(viewModel: TodoViewModel) {
    val mentalCalculations = viewModel.mentalCalculations.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Juego de Cálculos Mentales", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        mentalCalculations.value.randomOrNull()?.let { calculation ->
            Text(calculation.operation)
            var userResult by remember { mutableStateOf("") }

            OutlinedTextField(
                value = userResult,
                onValueChange = { userResult = it },
                label = { Text("Tu resultado") }
            )

            Button(onClick = {
                val isCorrect = viewModel.checkCalculationResult(calculation, userResult.toIntOrNull() ?: 0)
                if (isCorrect) {
                    // Mostrar mensaje de éxito
                } else {
                    // Mostrar mensaje de error
                }
            }) {
                Text("Enviar")
            }
        }
    }
}
