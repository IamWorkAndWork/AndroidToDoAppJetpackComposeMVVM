package com.example.todoappjetpackcomposemvvm.di

import android.content.Context
import androidx.room.Room
import com.example.todoappjetpackcomposemvvm.data.ToDoDao
import com.example.todoappjetpackcomposemvvm.data.ToDoDatabase
import com.example.todoappjetpackcomposemvvm.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ToDoDatabase = Room.databaseBuilder(context, ToDoDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDao(toDoDatabase: ToDoDatabase): ToDoDao = toDoDatabase.todoDao()

}