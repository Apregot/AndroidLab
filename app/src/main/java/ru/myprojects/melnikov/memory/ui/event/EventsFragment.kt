package ru.myprojects.melnikov.memory.ui.event
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_events.*
import ru.myprojects.melnikov.memory.R
import ru.myprojects.melnikov.memory.databinding.FragmentEventsBinding
import ru.myprojects.melnikov.memory.ui.common.EventReminder
import ru.myprojects.melnikov.memory.ui.event.adapter.EventsAdapter
import java.util.*

class EventsFragment:Fragment() {

    private var _binding: FragmentEventsBinding? = null
    private val binding get() = _binding!!

    private val eventsAdapter = EventsAdapter()

    private val eventsViewModel: EventsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.eventsRecyclerView.apply {
            adapter = eventsAdapter
            layoutManager = LinearLayoutManager(context)
        }

        eventsViewModel.getEvents().observe(viewLifecycleOwner) {
            eventsAdapter.reload(it)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}