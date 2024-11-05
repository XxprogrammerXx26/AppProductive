package com.myprimer.appproductive.Pages




import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import com.myprimer.appproductive.Modelo.TodoViewModel





import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.myprimer.appproductive.R


@Composable
fun MathGameScreen(viewModel: TodoViewModel) {
    val mentalCalculations = viewModel.mentalCalculations.observeAsState(emptyList())
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Juego de Tablas de Multiplicar", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        // Encabezado de la tabla
        TableHeader()

        // Generar operaciones de multiplicación del 1 al 12
        val operations = (1..12).flatMap { i ->
            (1..12).map { j -> "$i x $j = ?" }
        }

        // Usar LazyColumn para mostrar las operaciones
        LazyColumn {
            items(operations.chunked(12)) { rowOperations ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    rowOperations.forEach { calculation ->
                        MultiplicationCell(calculation, context)
                    }
                }
            }
        }
    }
}

@Composable
fun TableHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        (1..12).forEach { i ->
            Text(text = "$i", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun MultiplicationCell(calculation: String, context: Context) {
    val parts = calculation.split(" x ")
    val firstNumber = parts[0].toInt()
    val secondNumber = parts[1].split(" = ")[0].toInt()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Text("¿Cuánto es $calculation?", fontSize = 16.sp)

        var userResult by remember { mutableStateOf("") }

        OutlinedTextField(
            value = userResult,
            onValueChange = { userResult = it },
            label = { Text("Tu resultado") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            val correctResult = firstNumber * secondNumber
            val isCorrect = correctResult == (userResult.toIntOrNull() ?: -1)

            val message = if (isCorrect) {
                "¡Correcto!"
            } else {
                "Incorrecto. La respuesta era $correctResult"
            }
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

            // Reiniciar el resultado del usuario
            userResult = ""
        }) {
            Text("Enviar")
        }
    }
}




















































































//
//@Composable
//fun MathGameScreen(viewModel: TodoViewModel) {
//    val mentalCalculations = viewModel.mentalCalculations.observeAsState(emptyList())
//    val context = LocalContext.current
//
//    // Estado para la tabla actual
//    var currentTable by remember { mutableStateOf(1) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(10.dp),
//        verticalArrangement = Arrangement.spacedBy(10.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Juego de Tablas de Multiplicar", fontSize = 20.sp, fontWeight = FontWeight.Bold)
//
//        // Encabezado de la tabla
//        TableHeader()
//
//        // Generar operaciones de multiplicación de la tabla actual
//        val operations = (1..12).map { j -> "$currentTable x $j = ?" }
//
//        // Usar LazyColumn para mostrar las operaciones
//        LazyColumn {
//            items(operations) { calculation ->
//                MultiplicationCell(calculation, currentTable, context) { correct ->
//                    // Cambiar a la siguiente tabla si es correcto
//                    if (correct) {
//                        currentTable = if (currentTable < 12) currentTable + 1 else 1 // Reiniciar si se llega a la tabla 12
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun TableHeader() {
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.SpaceEvenly
//
//    ) {
//        (1..12).forEach { i ->
//            Text(text = "$i", fontSize = 18.sp, fontWeight = FontWeight.Bold)
//        }
//    }
//}
//
//@Composable
//fun MultiplicationCell(calculation: String, currentTable: Int, context: Context, onCorrect: (Boolean) -> Unit) {
//    val parts = calculation.split(" x ")
//    val firstNumber = parts[0].toInt()
//    val secondNumber = parts[1].split(" = ")[0].toInt()
//
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .padding(8.dp)
//            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
//            .padding(8.dp)
//    ) {
//        Text("¿Cuánto es $calculation?", fontSize = 18.sp)
//
//        var userResult by remember { mutableStateOf("") }
//
//        OutlinedTextField(
//            value = userResult,
//            onValueChange = { userResult = it },
//            label = { Text("Tu resultado") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Button(onClick = {
//            val correctResult = firstNumber * secondNumber
//            val isCorrect = correctResult == (userResult.toIntOrNull() ?: -1)
//
//            val message = if (isCorrect) {
//                "¡Correcto!"
//            } else {
//                "Incorrecto. La respuesta era $correctResult"
//            }
//            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
//
//            // Llamar a onCorrect para cambiar de tabla
//            onCorrect(isCorrect)
//
//            // Reiniciar el resultado del usuario
//            userResult = ""
//        }) {
//            Text("Enviar")
//        }
//    }
//}





































