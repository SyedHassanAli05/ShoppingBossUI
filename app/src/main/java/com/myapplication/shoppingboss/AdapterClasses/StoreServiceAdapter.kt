package com.myapplication.shoppingboss.AdapterClasses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.shoppingboss.ModelClasses.StoreSalesModel
import com.myapplication.shoppingboss.ModelClasses.StoreServiceModel
import com.myapplication.shoppingboss.R

class StoreServiceAdapter(): RecyclerView.Adapter<StoreServiceAdapter.ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StoreServiceAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_store_service,parent,false)
        return StoreServiceAdapter.ViewHolder(view)
    }

    lateinit var arrServiceList:ArrayList<StoreServiceModel>
    fun setServiceData(list: ArrayList<StoreServiceModel>)
    {
        arrServiceList=list
    }

    override fun onBindViewHolder(holder: StoreServiceAdapter.ViewHolder, position: Int) {
        holder.tvStoreService.text=arrServiceList[position].tvStoreService
    }

    override fun getItemCount(): Int {
        return arrServiceList.size
    }

    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView)
    {
        val tvStoreService: TextView =ItemView.findViewById(R.id.tvStoreService)

    }
}