package com.myapplication.shoppingboss.AdapterClasses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.shoppingboss.ModelClasses.MessagesModel
import com.myapplication.shoppingboss.R

class MessagesAdapter(): RecyclerView.Adapter<MessagesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.message_list_row,parent,false)
        return ViewHolder(view)
    }

    lateinit var arrMessage:ArrayList<MessagesModel>
    fun setDate(list: ArrayList<MessagesModel>)
    {
        arrMessage=list
    }

    override fun onBindViewHolder(holder: MessagesAdapter.ViewHolder, position: Int) {
        holder.ivIcon.setImageResource(arrMessage[position].icon)
        holder.tvNotification.text=arrMessage[position].notiMessage
        holder.tvDays.text=arrMessage[position].date_time
    }

    override fun getItemCount(): Int {
        return arrMessage.size
    }

    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView)
    {
        val ivIcon:ImageView=itemView.findViewById(R.id.ivIcon)
        val tvNotification:TextView=itemView.findViewById(R.id.tvNotification)
        val tvDays:TextView=itemView.findViewById(R.id.tvDays)
    }
}