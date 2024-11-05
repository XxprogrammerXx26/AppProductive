package com.myprimer.appproductive.Database

import androidx.room.Room
import android.app.Application

class MainApplication: Application() {


    companion object {            // acceso global y eficiente a la base de datos de tu aplicación.
        lateinit var  todoDatabase: TodoDatabase
    }

    override  fun onCreate() {
        super.onCreate()
        todoDatabase = Room.databaseBuilder(
            applicationContext,
            TodoDatabase::class.java,
            TodoDatabase.NAME
        ).build()
    }

}



