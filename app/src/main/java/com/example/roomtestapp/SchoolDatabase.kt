package com.example.roomtestapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomtestapp.entities.Director
import com.example.roomtestapp.entities.School
import com.example.roomtestapp.entities.Student
import com.example.roomtestapp.entities.Subject
import com.example.roomtestapp.entities.relations.StudentsSubjectCrossRef
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(
    entities = [
        School::class,
        Student::class,
        Director::class,
        Subject::class,
        StudentsSubjectCrossRef::class

    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val schoolDao: SchoolDao

    companion object {
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        @InternalCoroutinesApi
        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }

            }
        }

    }
}




