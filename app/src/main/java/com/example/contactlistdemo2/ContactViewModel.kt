package com.example.contactlistdemo2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ContactViewModel(application: Application): AndroidViewModel(application) {
    val repository: ContactRepository
    init {
        val dao = ContactDatabase.getDatabaseInstance(application).contactsDao()
        repository = ContactRepository(dao)
    }

    fun addContacts(contacts: Contacts){
        repository.insertContact(contacts)
    }

    fun getAllContacts():LiveData<List<Contacts>> = repository.getAllContacts()

}