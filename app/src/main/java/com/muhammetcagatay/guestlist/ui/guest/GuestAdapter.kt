package com.cagataymuhammet.guestlist.ui.guest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cagataymuhammet.guestlist.db.entity.Event
import com.cagataymuhammet.guestlist.db.entity.Guest
import com.cagataymuhammet.guestlist.model.GuestItem
import com.muhammetcagatay.guestlist.R

/**
 * Created by Muhammet ÇAĞATAY on 16,Şubat,2020
 */

class GuestAdapter(val guestList: List<Guest>, val listener: OnItemClickListener): RecyclerView.Adapter<GuestAdapter.GuestViewHolder>() {

    interface OnItemClickListener {
        fun onClick(guestItem: Guest)
        fun onLongClick(guestItem: Guest,position: Int): Boolean
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {

        holder.txtName?.text =guestList.get(position).first_name +" " +guestList.get(position).last_name!!.toUpperCase()

        if(guestList.get(position).job_title!=null)
        {
            holder.txtJob?.text =guestList.get(position).job_title
        }
        else
        {
            holder.txtJob?.text ="Software Engineer"
        }



        holder.txtCompany?.text ="@" + guestList.get(position).company
        holder.click(guestList.get(position),listener,position)
    }

    override fun onCreateViewHolder(parentView: ViewGroup, position: Int): GuestViewHolder {
        val view = LayoutInflater.from(parentView.context).inflate(R.layout.list_item_guest, parentView, false)
        return GuestViewHolder(view);
    }

    override fun getItemCount(): Int {
        return guestList.size
    }

    class GuestViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val txtName = itemView.findViewById<TextView>(R.id.txt_name)
        val txtJob = itemView.findViewById<TextView>(R.id.txt_job)
        val txtCompany = itemView.findViewById<TextView>(R.id.txt_company)

        fun click(guestItem: Guest,listener: OnItemClickListener, position: Int)
        {
            itemView.setOnClickListener {
                listener.onClick(guestItem)
            }

            itemView.setOnLongClickListener {
                listener.onLongClick(guestItem,position)
            }
        }
    }

}