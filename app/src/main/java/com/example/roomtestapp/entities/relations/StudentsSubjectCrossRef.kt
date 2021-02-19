package com.example.roomtestapp.entities.relations

import androidx.room.Entity

@Entity(primaryKeys = ["studentName", "subjectName"])
data class StudentsSubjectCrossRef (
    val studentName: String,
    val subjectName: String
)