package com.example.roomdatabasemvvm.application

import android.app.Application
import androidx.room.Room
import com.example.roomdatabasemvvm.database.WordRoomDatabase
import com.example.roomdatabasemvvm.repository.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication : Application(){

    private val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { WordRoomDatabase.getDatabase(applicationScope,this) }
    val repository by lazy { WordRepository(database.wordDao()) }

}