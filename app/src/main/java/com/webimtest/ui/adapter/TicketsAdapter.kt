package com.webimtest.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.webimtest.data.dto.Ticket
import com.webimtest.databinding.CardTicketBinding


class TicketsAdapter :
    ListAdapter<Ticket, TicketViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val binding = CardTicketBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TicketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val field = getItem(position)
        holder.bind(field)
    }
}

class TicketViewHolder(
    private val binding: CardTicketBinding
) : RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(fields: Ticket) {
        binding.apply {
            cost.text = "${fields.cost} руб"
            from.text = fields.from
            dest.text = fields.dest
            date.text = fields.date
        }
    }
}

object DiffCallback : DiffUtil.ItemCallback<Ticket>() {
    override fun areItemsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
        return oldItem.cost == newItem.cost
    }

    override fun areContentsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
        return oldItem == newItem
    }
}