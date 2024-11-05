package com.myprimer.appproductive.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.myprimer.appproductive.Modelo.Todo
import androidx.room.Room
import android.content.Context




@Database(entities = [Todo::class], version = 1)
@TypeConverters(Converters::class)
abstract class TodoDatabase : RoomDatabase() {


    companion object {
        const val NAME = "Todo_DB"
    }



    abstract fun getTodoDao(): TodoDao

}










