package com.myapplication.shoppingboss.AdapterClasses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.shoppingboss.ModelClasses.RewardListModel
import com.myapplication.shoppingboss.ModelClasses.RewardTopModel
import com.myapplication.shoppingboss.R

class RewardListAdapter(val callback: (position: Int, item: RewardListModel) -> Unit): RecyclerView.Adapter<RewardListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RewardListAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_rewards_list,parent,false)
        return ViewHolder(view)
    }

    lateinit var arrList:ArrayList<RewardListModel>
    fun setData(list:ArrayList<RewardListModel>)
    {
        arrList=list
    }

    override fun onBindViewHolder(holder: RewardListAdapter.ViewHolder, position: Int) {
       holder.ivIcon.setImageResource(arrList[position].Icon)
        holder.tvComplementary.text=arrList[position].Complementary
        holder.tvPoints.text=arrList[position].Points
        holder.tvDetail.text=arrList[position].Detail
        holder.tvReissue.text=arrList[position].Reissue

        holder.itemView.setOnClickListener {
            callback(position,arrList[position])
        }

    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    class ViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView)
    {
        val ivIcon:ImageView=itemView.findViewById(R.id.ivIcon)
        val tvComplementary:TextView=itemView.findViewById(R.id.tvComplementary)
        val tvPoints:TextView=itemView.findViewById(R.id.tvPoints)
        val tvDetail:TextView=itemView.findViewById(R.id.tvDetail)
        val tvReissue:TextView=itemView.findViewById(R.id.tvReissue)

    }
}