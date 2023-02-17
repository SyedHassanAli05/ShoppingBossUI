package com.myapplication.shoppingboss.Fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.myapplication.shoppingboss.Activities.CreateLoginActivity
import com.myapplication.shoppingboss.AdapterClasses.RewardListAdapter
import com.myapplication.shoppingboss.AdapterClasses.RewardTopAdapter
import com.myapplication.shoppingboss.ModelClasses.RewardListModel
import com.myapplication.shoppingboss.ModelClasses.RewardTopModel
import com.myapplication.shoppingboss.R

class RewardFragment :  Fragment() {
    lateinit var view1: View
    lateinit var ivclose:ImageView
    lateinit var btn_redeem:Button
    lateinit var btn_close:Button
    lateinit var adopter :RewardListAdapter
    lateinit var rvItem: RecyclerView
    lateinit var rvRewardList:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view1 = inflater.inflate(R.layout.activity_reward_fragment, container, false)
        findView()

        rvItem.layoutManager=LinearLayoutManager(requireContext(),RecyclerView.HORIZONTAL,
            false
        ).apply { rvItem.layoutManager = this }

        var items = arrayListOf<RewardTopModel>(
            RewardTopModel(

                "All",
                android.R.color.holo_blue_dark,
                android.R.color.black,
            ),

            RewardTopModel(

                "Complimentary",
                android.R.color.holo_blue_dark,
                android.R.color.black,
            ),

            RewardTopModel(

                "Discount",
                android.R.color.holo_blue_dark,
                android.R.color.black,
            ),

            RewardTopModel(

                "Earned",
                android.R.color.holo_blue_dark,
                android.R.color.black,
            ),
        )

        rvRewardList.layoutManager=LinearLayoutManager(requireContext())
        val displayList=ArrayList<RewardListModel>()

        displayList.add(RewardListModel(R.drawable.complementaryicon,"Complimentary", "0 Points", "Complimentary First Lube Oil and Filter", "Re-issue"))
        displayList.add(RewardListModel(R.drawable.discounticon,"Discount", "0 Points", "40.95 Lube, Oil and Filters",  "Redeem"))
        displayList.add(RewardListModel(R.drawable.earnedicon,"Earned", "0 Points", "Tire Rotation",  "Re-Issue"))
        displayList.add(RewardListModel(R.drawable.complementaryicon,"Complimentary", "0 Points", "Complimentary First Lube Oil and Filter",  "Re-issue"))
        displayList.add(RewardListModel(R.drawable.complementaryicon,"Complimentary", "0 Points", "Complimentary First Lube Oil and Filter",  "Re-issue"))
        displayList.add(RewardListModel(R.drawable.discounticon,"Discount", "0 Points", "40.95 Lube, Oil and Filters",  "Redeem"))
        displayList.add(RewardListModel(R.drawable.discounticon,"Discount", "0 Points", "40.95 Lube, Oil and Filters",  "Redeem"))
        displayList.add(RewardListModel(R.drawable.earnedicon,"Earned", "0 Points", "Tire Rotation",  "Re-issue"))
        displayList.add(RewardListModel(R.drawable.earnedicon,"Earned", "0 Points", "Tire Rotation",  "Re-issue"))
        displayList.add(RewardListModel(R.drawable.complementaryicon,"Complimentary", "0 Points", "Complimentary First Lube Oil and Filter",  "Re-issue"))
        rvItem.adapter= RewardTopAdapter(items,requireContext())
        { prePosition: Int, selectedPost: Int, item: RewardTopModel ->
            if (item.title.equals("All")){
                adopter.setData(displayList)
                rvRewardList.adapter=adopter
            }
            else{
                adopter.setData(displayList.filter { it.Complementary.equals(item.title) } as ArrayList<RewardListModel>)
                rvRewardList.adapter=adopter
            }

        }
        adopter=RewardListAdapter() { position:Int, item:RewardListModel->

            if(item.Reissue=="Redeem" ){
                val dialog=BottomSheetDialog(requireContext())
                val view=layoutInflater.inflate(R.layout.dialog_reward_redeem,null)
                dialog.setContentView(view)

                ivclose=dialog.findViewById<ImageView>(R.id.ivclose)!!
                ivclose.setOnClickListener {
                  dialog.dismiss()
              }

                btn_redeem=dialog.findViewById<Button>(R.id.btn_redeem)!!
                btn_redeem.setOnClickListener {
                    dialog.dismiss()
                    val dialog=BottomSheetDialog(requireContext())
                    val view=layoutInflater.inflate(R.layout.dialog_reward_detail,null)
                    dialog.setContentView(view)
                    dialog.setCancelable(false)
                    dialog.show()
                    btn_close=dialog.findViewById<Button>(R.id.btn_close)!!
                    btn_close.setOnClickListener {
                        dialog.dismiss()
                    }

                }
                dialog.setCancelable(false)
                dialog.show()

            }else{

                val dialog=BottomSheetDialog(requireContext())
                val view=layoutInflater.inflate(R.layout.dialog_reward_detail,null)
                dialog.setContentView(view)
                dialog.setCancelable(false)
                dialog.show()
                btn_close=dialog.findViewById<Button>(R.id.btn_close)!!
                btn_close.setOnClickListener {
                    dialog.dismiss()
                }
            }


        }
        adopter.setData(displayList)
        rvRewardList.adapter=adopter
        return view1
    }

    private fun findView()
    {
        rvItem=view1.findViewById(R.id.rvTopList)
        rvRewardList=view1.findViewById(R.id.rvRewardList)



    }



}