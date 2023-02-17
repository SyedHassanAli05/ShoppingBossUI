package com.myapplication.shoppingboss.AdapterClasses

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.shoppingboss.ModelClasses.StoreSalesModel
import com.myapplication.shoppingboss.R

class StoreSalesAdapter():RecyclerView.Adapter<StoreSalesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StoreSalesAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_store_sales,parent,false)
        return ViewHolder(view)

    }
    lateinit var arrSaleList:ArrayList<StoreSalesModel>
    fun setSaleData(list: ArrayList<StoreSalesModel>)
    {
        arrSaleList=list
    }

    override fun onBindViewHolder(holder: StoreSalesAdapter.ViewHolder, position: Int) {
        holder.tvSaleDays.text=arrSaleList[position].tvSaleDays
    }

    override fun getItemCount(): Int {
       return arrSaleList.size
    }

    class ViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView)
    {
        val tvSaleDays:TextView=ItemView.findViewById(R.id.tvSaleDays)

    }
}