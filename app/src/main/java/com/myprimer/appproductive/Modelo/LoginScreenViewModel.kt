package com.myprimer.appproductive.Modelo

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.myprimer.appproductive.MainScreen
import kotlinx.coroutines.launch



class  LoginScreenViewModel: ViewModel(){
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    fun signInWithGoogleCredential(credential: AuthCredential, MainScreen: () -> Unit )
            =viewModelScope.launch {
        try {
            auth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("Usuario", "Logeado con Google Exitoso!")
                        MainScreen()
                    }
                }
                .addOnFailureListener {
                    Log.d("Usuario", "Fallo  al conectar con Google")
                }

        }
        catch (ex:Exception){
            Log.d("Usuario","Excepcion al logear con Google:" +

                    "${ex.localizedMessage}")

        }
            }

}