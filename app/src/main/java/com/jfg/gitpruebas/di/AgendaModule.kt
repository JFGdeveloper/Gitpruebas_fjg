package com.jfg.gitpruebas.di

import com.jfg.gitpruebas.model.Agenda
import com.jfg.gitpruebas.model.Contact
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AgendaModule {

    @Provides
    fun providerContacts(): List<Contact>{
        return listOf(Contact("Javi"), Contact("Irene"), Contact("Noelia"))
    }

    @Provides
    fun providesAgendaJob(list: List<Contact>) = Agenda("Trabajo",list)

}