package com.myapplication.shoppingboss.AdapterClasses

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.annotation.VisibleForTesting
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.myapplication.shoppingboss.Fragments.RewardFragment
import com.myapplication.shoppingboss.ModelClasses.BottomNavModel
import com.myapplication.shoppingboss.ModelClasses.RewardTopModel
import com.myapplication.shoppingboss.R

class RewardTopAdapter(
    var mData:ArrayList<RewardTopModel>, var mContext: Context,
    var callBackSelected:(prePosition: Int, selectedPost: Int, item: RewardTopModel)-> Unit):
    RecyclerView.Adapter<ViewHolder>(){

    var selected: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_reward_top, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ViewHolder(item: View):RecyclerView.ViewHolder(item){

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = mData[position]
        val tvTopItem = holder.itemView.findViewById<TextView>(R.id.tvItemTop)
        val viewSelection = holder.itemView.findViewById<View>(R.id.viewSelected)

        tvTopItem.text = item.title
        if (selected == position) {
            tvTopItem.setTextColor(Color.parseColor("#00AEEF"))
            viewSelection.visibility = View.VISIBLE
        }

        else
        {
            tvTopItem.setTextColor(Color.parseColor("#000000"))
            viewSelection.visibility = View.GONE
        }
        holder.itemView.setOnClickListener {
            val prePos = selected
            selected = position
            notifyItemChanged(position)
            notifyItemChanged(prePos)
            callBackSelected.invoke(prePos, selected, item)
        }
    }
}
