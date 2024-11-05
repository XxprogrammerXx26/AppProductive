package com.myprimer.appproductive.Modelo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myprimer.appproductive.Database.MainApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoViewModel : ViewModel() {

    // Estado para el juego de acertijos lógicos

    private val _logicPuzzles = MutableLiveData<List<LogicPuzzle>>()
    val logicPuzzles: LiveData<List<LogicPuzzle>> get() = _logicPuzzles

    fun addLogicPuzzle(puzzle: LogicPuzzle) {
        _logicPuzzles.value = _logicPuzzles.value.orEmpty() + puzzle
    }

    // Función para verificar la respuesta del usuario en el juego de acertijos lógicos
    fun checkLogicAnswer(puzzle: LogicPuzzle, userAnswer: String): Boolean {
        return puzzle.answer.equals(userAnswer, ignoreCase = true)
    }

    // Estado para el juego de cálculos mentales
    private val _mentalCalculations = MutableLiveData<List<MentalCalculation>>()
    val mentalCalculations: LiveData<List<MentalCalculation>> get() = _mentalCalculations


    fun addMentalCalculation(calculation: MentalCalculation) {
        _mentalCalculations.value = _mentalCalculations.value.orEmpty() + calculation
    }

    // Función para verificar el resultado de la operación matemática
    fun checkCalculationResult(calculation: MentalCalculation, userResult: Int): Boolean {
        return calculation.result == userResult
    }


    // Estado para el juego de palabras aprendidas
    private val _learnedWords = MutableLiveData<List<LearnedWord>>()
    val learnedWords: LiveData<List<LearnedWord>> get() = _learnedWords

    fun addLearnedWord(word: LearnedWord) {
        _learnedWords.value = _learnedWords.value.orEmpty() + word
    }






    val todoDao  = MainApplication.todoDatabase.getTodoDao()
    val todoList : LiveData<List<Todo>> =  todoDao.getAllTodo()




    fun addTodo(title : String){

        viewModelScope.launch(Dispatchers.IO){
            todoDao.addTodo(Todo(title = title, createdAt = Date.from(Instant.now())))
        }


    }

    fun deleteTodo(id : Int) {
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.deleteTodo(id)


        }

    }


}

