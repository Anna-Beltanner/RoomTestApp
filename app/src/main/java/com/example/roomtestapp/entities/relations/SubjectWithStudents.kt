package com.example.roomtestapp.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.roomtestapp.entities.Student
import com.example.roomtestapp.entities.Subject

data class SubjectWithStudents (

@Embedded
val subject: Subject,
@Relation(
    parentColumn = "subjectName",
    entityColumn = "studentName",
    associateBy = Junction(StudentsSubjectCrossRef::class)
)

val students: List<Student>

)
