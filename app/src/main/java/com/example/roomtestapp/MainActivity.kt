package com.example.roomtestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.roomtestapp.entities.Director
import com.example.roomtestapp.entities.School
import com.example.roomtestapp.entities.Student
import com.example.roomtestapp.entities.Subject

import kotlinx.coroutines.launch
import com.example.roomtestapp.entities.relations.StudentsSubjectCrossRef
import kotlinx.coroutines.InternalCoroutinesApi

class MainActivity : AppCompatActivity() {

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = SchoolDatabase.getInstance(this).schoolDao

        val directors = listOf(
            Director("Anna Petrova", "Swift School"),
            Director("Alex Ivanov", "Kotlin School"),
            Director("Peter Sidorov", "Java School")
        )
        val schools = listOf(
            School("Java School"),
            School("Kotlin School"),
            School("Android School")
        )
        val subjects = listOf(
            Subject("JetPack Compose"),
            Subject("RxJava"),
            Subject("Fragment"),
            Subject("Coroutines"),
            Subject("Flow")
        )
        val students = listOf(
            Student("Tom Hardy", 2, "Kotlin School"),
            Student("Elon Mask", 5, "Kotlin School"),
            Student("Tom Hardy", 8, "Java School"),
            Student("Jonny Dapp", 1, "Kotlin School"),
            Student("Tom Hanks", 2, "Swift School")
        )
        val studentSubjectRelations = listOf(
            StudentsSubjectCrossRef("Tom Hardy", "Dating for programmers"),
            StudentsSubjectCrossRef("Tom Hardy", "Avoiding depression"),
            StudentsSubjectCrossRef("Tom Hardy", "Bug Fix Meditation"),
            StudentsSubjectCrossRef("Elon Mask", "Logcat for Newbies"),
            StudentsSubjectCrossRef("Elon Mask", "Dating for programmers"),
            StudentsSubjectCrossRef("Gill Bates", "How to use Google"),
            StudentsSubjectCrossRef("Jonny Dapp", "Logcat for Newbies"),
            StudentsSubjectCrossRef("Tom Hanks", "Avoiding depression"),
            StudentsSubjectCrossRef("Tom Hanks", "Dating for programmers")
        )
        lifecycleScope.launch {
            directors.forEach { dao.insertDirector(it) }
            schools.forEach { dao.insertSchool(it) }
            subjects.forEach { dao.insertSubject(it) }
            students.forEach { dao.insertStudent(it) }
            studentSubjectRelations.forEach { dao.insertStudentSubjectCrossRef(it) }

            val schoolWithDirector = dao.getSchoolAndDirectorWithSchoolName("Kotlin School")

            val schoolWithStudents = dao.getSchoolWithStudents("Kotlin School")
        }
    }
}
