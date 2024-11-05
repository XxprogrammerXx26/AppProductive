package com.myprimer.appproductive.Database

import androidx.room.TypeConverter
import java.util.Date

class Converters {    //utiliza para almacenar tipos de datos complejos
                      // en la base de datos que Room no admite de forma nativa

    @TypeConverter
    fun fromDate(date: Date) : Long{
        return  date.time
    }

    @TypeConverter
    fun  toDate(time : Long) : Date {
        return  Date(time)
    }

}
