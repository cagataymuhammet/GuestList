package com.cagataymuhammet.guestlist.ui.event

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cagataymuhammet.guestlist.db.entity.Event
import com.muhammetcagatay.guestlist.R

/**
 * Created by Muhammet ÇAĞATAY on 16,Şubat,2020
 */

class EventAdapter(val eventList: List<Event>,val listener: OnItemClickListener): RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    interface OnItemClickListener {
        fun onClick(eventItem: Event)
        fun onLongClick(eventItem: Event,position: Int): Boolean
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
      //  holder.txtID?.text = eventList.get(position).event_id.toString()
        holder.txtName?.text =eventList.get(position).name
        holder.txtDate?.text =eventList.get(position).starts
        holder.click( eventList.get(position),listener,position)
    }

    override fun onCreateViewHolder(parentView: ViewGroup, position: Int): EventViewHolder {
        val view = LayoutInflater.from(parentView.context).inflate(R.layout.list_item_event, parentView, false)
        return EventViewHolder(view);
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    class EventViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtName = itemView.findViewById<TextView>(R.id.txt_event_name)
        val txtDate = itemView.findViewById<TextView>(R.id.txt_date)
        //val txtID = itemView.findViewById<TextView>(R.id.txt_user_id)

        fun click(event: Event,listener: OnItemClickListener, position: Int)
        {
            itemView.setOnClickListener {
                listener.onClick(event)
            }

            itemView.setOnLongClickListener {
                listener.onLongClick(event,position)
            }
        }
    }

}