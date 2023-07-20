package com.example.tk3.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tk3.data.entity.MyNumber

@Dao
interface NumberDao {
    @Query("SELECT * FROM myNumber")
    fun getAll(): List<MyNumber>

    @Insert
    fun insertAll(vararg myNumber: MyNumber)
}