package com.example.biometricattendance

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface EntryDao {
    @Insert
    suspend fun insert(entry: Entry)
}
