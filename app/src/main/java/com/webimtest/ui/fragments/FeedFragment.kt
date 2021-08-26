package com.webimtest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.webimtest.databinding.FragmentAuthBinding
import com.webimtest.databinding.FragmentFeedBinding
import com.webimtest.ui.adapter.TicketsAdapter
import com.webimtest.ui.viewmodel.AuthViewModel
import com.webimtest.ui.viewmodel.TicketsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FeedFragment : Fragment() {

    private val viewModel: TicketsViewModel by viewModels(ownerProducer = ::requireParentFragment)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFeedBinding.inflate(inflater, container, false)
        val adapter = TicketsAdapter()

        binding.container.adapter = adapter

        viewModel.dataTickets.observe(viewLifecycleOwner) { listTickets ->
            adapter.submitList(listTickets)
        }

        return binding.root
    }
}