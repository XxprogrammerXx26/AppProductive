package com.myprimer.appproductive.Database

import androidx.room.Room
import android.app.Application

class MainApplication: Application() {


    companion object {
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