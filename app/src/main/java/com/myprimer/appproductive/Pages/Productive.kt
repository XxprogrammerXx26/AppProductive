package com.myprimer.appproductive.Pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprimer.appproductive.Modelo.Todo
import com.myprimer.appproductive.Modelo.TodoViewModel
import com.myprimer.appproductive.R
import java.text.SimpleDateFormat
import java.util.Locale


//la utilizamos para definir una parte de la interfaz de usuario.
@Composable
fun Productive(modifier: Modifier = Modifier, viewModel: TodoViewModel) {

    val todoList by viewModel.todoList.observeAsState()
    var inputText by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)  // Use theme background
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween // Make it look more spaced out
        ) {
            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it },
                modifier = Modifier.weight(1f).padding(end = 8.dp),  // Adjust padding
                placeholder = { Text("Add a task...") },  // Professional placeholder
                maxLines = 1
            )
            Button(
                onClick = {
                    viewModel.addTodo(inputText)
                    inputText = ""
                },
                shape = RoundedCornerShape(8.dp), // Rounded button corners
                modifier = Modifier.defaultMinSize(minHeight = 56.dp) // Ensure button height
            ) {
                Text(text = "Add")
            }
        }

        todoList?.let {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),  // Add space between items
                content = {
                    itemsIndexed(it) { index: Int, item: Todo ->
                        TodoItem(item = item, onDelete = {
                            viewModel.deleteTodo(item.id)
                        })
                    }
                }
            )
        } ?: Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "No tasks added yet",
            style = MaterialTheme.typography.bodyMedium,  // Use theme typography
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f) // Faint text color
        )
    }
}

@Composable
fun TodoItem(item: Todo, onDelete: () -> Unit) {
    Surface(  // Use Surface to manage elevation and background
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        tonalElevation = 2.dp // Add elevation for a sleek card-like effect
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = SimpleDateFormat("HH:mm aa, dd/MM", Locale.ENGLISH).format(item.createdAt),
                    style = MaterialTheme.typography.labelSmall,  // Smaller timestamp
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                )
                Spacer(modifier = Modifier.height(4.dp))  // Space between timestamp and title
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodyLarge,  // Larger text for title
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            IconButton(onClick = onDelete) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_delete_24),
                    contentDescription = "Delete",
                    tint = MaterialTheme.colorScheme.error  // Highlight delete with error color
                )
            }
        }
    }
}











































