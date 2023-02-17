package com.myapplication.shoppingboss.AdapterClasses

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.shoppingboss.ModelClasses.BottomNavModel
import com.myapplication.shoppingboss.R

class BottomNavAdaptor (var mData: ArrayList<BottomNavModel>, var mContext: Context,
                        var callBackSelected: (prePosition: Int, selectedPost: Int, item: BottomNavModel) -> Unit
) :
    RecyclerView.Adapter<BottomNavAdaptor.BottomItemVH>() {
    var selected: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomItemVH {
        return BottomItemVH(
            LayoutInflater.from(mContext).inflate(R.layout.item_btns, parent, false)
        )
    }



    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: BottomNavAdaptor.BottomItemVH, position: Int)
    {

        val item = mData[position]
        holder.title.text=item.title
       // holder.imgView.setImageResource(item.icon ?: 0)


        if (selected == position) {
           holder.imgView.setImageResource(item.iconSelected?:0)
            holder.title.setTextColor(mContext.getColor(item.colorSelected ?: 0))
            holder.cardview.setCardBackgroundColor(mContext.getColor(item.colorSelected?:0))
        } else {
            holder.imgView.setImageResource(item.icon?:0)
            holder.title.setTextColor(mContext.getColor(item.color ?: 0))
            holder.cardview.setCardBackgroundColor(mContext.getColor(android.R.color.white))
        }
        holder.itemView.setOnClickListener {
            val prePos = selected
            selected = position
            notifyItemChanged(position)
            notifyItemChanged(prePos)
            callBackSelected.invoke(prePos, selected, item)
        }
    }

    override fun getItemCount(): Int {
        return mData.count()
    }


    class BottomItemVH(item: View) : RecyclerView.ViewHolder(item) {

        val imgView: ImageView =itemView.findViewById(R.id.ivBtm)
        val title: TextView = itemView.findViewById(R.id.tvBtm)
        val cardview:CardView=itemView.findViewById(R.id.cv)
    }
}


