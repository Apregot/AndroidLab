package ru.myprojects.melnikov.memory.ui.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.myprojects.melnikov.memory.ui.common.EventReminder
import java.util.*

class EventsViewModel: ViewModel() {

    private val eventsReminder: MutableLiveData<List<EventReminder>> = MutableLiveData()

    init {
        loadEventsReminder()
    }

    fun getEvents(): LiveData<List<EventReminder>>{
        return eventsReminder
    }

    private fun loadEventsReminder() {
        val list = listOf(EventReminder("Title","Desc", Date()),EventReminder("Title2","Desc2", Date(1)),
            EventReminder("Title","Desc", Date()),EventReminder("Title2","Desc2", Date(20)),
            EventReminder("Title","Desc", Date()),EventReminder("Title2","Desc2", Date(100)),
            EventReminder("Title","Desc", Date()),EventReminder("Title2","Desc2", Date(10000)),
            EventReminder("Title","Desc", Date()),EventReminder("Title2","Desc2", Date(100000)),
            EventReminder("Title","Desc", Date()),EventReminder("Title2","Desc2", Date(1000000)),
            EventReminder("Title","Desc", Date()),EventReminder("Title2","Desc2", Date(10000000)),
            EventReminder("Title","Desc", Date()),EventReminder("Title2","Desc2", Date(100000000)),
            EventReminder("Title","Desc", Date()),EventReminder("Title2","Desc2", Date(1000000000)),
            EventReminder("Title","Desc", Date()),EventReminder("Title2","Desc2", Date(100000000000000))
        )
        eventsReminder.postValue(list)
    }

}