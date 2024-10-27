package com.myprimer.appproductive.Pages


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprimer.appproductive.Modelo.LearnedWord
import com.myprimer.appproductive.Modelo.TodoViewModel


@Composable
fun LanguageGameScreen(viewModel: TodoViewModel) {
    val learnedWords = viewModel.learnedWords.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Juego de Palabras Aprendidas", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        var word by remember { mutableStateOf("") }
        var meaning by remember { mutableStateOf("") }

        OutlinedTextField(
            value = word,
            onValueChange = { word = it },
            label = { Text("Palabra") }
        )
        OutlinedTextField(
            value = meaning,
            onValueChange = { meaning = it },
            label = { Text("Significado") }
        )

        Button(onClick = {
            viewModel.addLearnedWord(LearnedWord(word, meaning))
            word = ""
            meaning = ""
            // Muestra un mensaje de éxito o limpia los campos
        }) {
            Text("Agregar palabra")
        }

        // Lista de palabras aprendidas
        learnedWords.value.forEach { learnedWord ->
            Text("${learnedWord.word}: ${learnedWord.meaning}")
        }
    }
}