package com.example.roomtestapp.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomtestapp.entities.School
import com.example.roomtestapp.entities.Student

data class SchoolWithStudents (

    @Embedded val school: School,
            @Relation(
                parentColumn = "schoolName",
                entityColumn = "schoolName"
            )

            val students: List<Student>
)