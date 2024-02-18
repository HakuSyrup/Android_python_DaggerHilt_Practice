package com.hakusyrup.pythonchaq.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DIModule {
//    @Provides
//    @Singleton
//    fun provideRunPythonViewModel(): IRunPythonViewModel {
//        return RunPythonViewModel()
//    }
    @Provides
    @Singleton
    @Named("InjectionTest")
    fun ProvidesInjectionTest() : String = "Injection Test"
}