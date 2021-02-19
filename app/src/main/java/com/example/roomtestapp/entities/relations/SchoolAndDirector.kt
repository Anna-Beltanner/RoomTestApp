package com.example.roomtestapp.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomtestapp.entities.Director
import com.example.roomtestapp.entities.School

data class SchoolAndDirector (
    @Embedded val school: School,

    @Relation(

        parentColumn = "schoolName",
        entityColumn = "schoolName"


        )
    val director: Director
)