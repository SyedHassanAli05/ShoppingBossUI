package com.myapplication.shoppingboss.AdapterClasses

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.shoppingboss.ModelClasses.SelectAccountModel
import com.myapplication.shoppingboss.R

class SelectAccoutAdapter():RecyclerView.Adapter<SelectAccoutAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SelectAccoutAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_select_account,parent,false)
        return ViewHolder(view)
    }

    lateinit var arrList:ArrayList<SelectAccountModel>
    fun setData(list:ArrayList<SelectAccountModel>)
    {
        arrList=list
    }
    override fun onBindViewHolder(holder: SelectAccoutAdapter.ViewHolder, position: Int) {
        holder.ivCard.setImageResource(arrList[position].image)
        holder.tvDes.text=arrList[position].title
        holder.tvVersion.text=arrList[position].version
        holder.tvtitle2.text=arrList[position].title2
    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    class ViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView)
    {
        val ivCard:ImageView=ItemView.findViewById(R.id.ivCard)
        val tvDes:TextView=ItemView.findViewById(R.id.tvDes)
        val tvVersion:TextView=ItemView.findViewById(R.id.tvVersion)
        val tvtitle2:TextView=ItemView.findViewById(R.id.tvtitle2)
    }
}