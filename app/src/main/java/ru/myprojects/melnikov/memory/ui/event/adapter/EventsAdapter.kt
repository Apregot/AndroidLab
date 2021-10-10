package ru.myprojects.melnikov.memory.ui.event.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.myprojects.melnikov.memory.R
import ru.myprojects.melnikov.memory.ui.common.EventReminder

class EventsAdapter : RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    private var eventReminderList = listOf<EventReminder>()

    fun reload(events: List<EventReminder>){
        eventReminderList = events
        notifyItemRangeChanged(0, events.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return EventViewHolder(inflater.inflate(R.layout.event_item, parent, false))
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(eventReminderList[position])
    }

    override fun getItemCount(): Int  = eventReminderList.size

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val nameView: TextView by lazy { itemView.findViewById(R.id.eventReminderItem_name) }

        @SuppressLint("SetTextI18n")
        fun bind(eventReminder:EventReminder) {
            nameView.text = eventReminder.title + " " + eventReminder.desc + " " + eventReminder.dateStart
        }
    }
}