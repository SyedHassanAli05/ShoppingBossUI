package com.myapplication.shoppingboss.AdapterClasses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.shoppingboss.ModelClasses.AccountModel
import com.myapplication.shoppingboss.R

class AccountAdapter() :
    RecyclerView.Adapter<AccountAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.account_row,parent,false)
        return ViewHolder(view)
    }
    lateinit var arrlist:ArrayList<AccountModel>
    fun set_Data(list: ArrayList<AccountModel>){
        arrlist=list
    }


    override fun onBindViewHolder(holder: AccountAdapter.ViewHolder, position: Int) {
        holder.tvDate.text=arrlist[position].date
        holder.tvPoints.text=arrlist[position].point
        //holder.ivIcon.setImageResource(arrlist[position].icon)
        holder.tvDetail.text=arrlist[position].detail
    }

    override fun getItemCount(): Int {
        return arrlist.size
    }

    class ViewHolder(Itemview: View):RecyclerView.ViewHolder(Itemview)
    {
        val tvDate:TextView=itemView.findViewById(R.id.tvDate)
        val tvPoints:TextView=itemView.findViewById(R.id.tvPoints)
       // val ivIcon:ImageView=itemView.findViewById(R.id.ivIcon)
        val tvDetail:TextView=itemView.findViewById(R.id.tvDetail)
    }
}