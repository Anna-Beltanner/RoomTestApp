package com.example.roomtestapp.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.roomtestapp.entities.Student
import com.example.roomtestapp.entities.Subject

data class StudentWithSubjects (
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentsSubjectCrossRef::class)
    )

    val subjects: List<Subject>

    )