package com.myapplication.shoppingboss.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.myapplication.shoppingboss.Activities.SettingActivity
import com.myapplication.shoppingboss.AdapterClasses.AccountAdapter
import com.myapplication.shoppingboss.AdapterClasses.SelectAccoutAdapter
import com.myapplication.shoppingboss.ModelClasses.AccountModel
import com.myapplication.shoppingboss.ModelClasses.SelectAccountModel
import com.myapplication.shoppingboss.R

class FragmentActivity : Fragment() {
    lateinit var view1: View
    lateinit var ivArrowDown:ImageView
    lateinit var ivArrowUp:ImageView
    lateinit var cons1:ConstraintLayout
    lateinit var cons2:ConstraintLayout
    lateinit var recyclerlist:RecyclerView
    lateinit var rvSelectAccount:RecyclerView
    lateinit var ivSettingIcon:ImageView
    lateinit var constraint_ly1:ConstraintLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        view1 = inflater.inflate(R.layout.activity_fragment, container, false)

        findView()
        onClick()
        rvSelectAccount.layoutManager=LinearLayoutManager(requireContext())

        val showAccounts=ArrayList<SelectAccountModel>()
        showAccounts.add(SelectAccountModel(R.drawable.card2, "Pettijohn Auto Center", "","GOLD - 3248 8974 9873 5312"))
        showAccounts.add(SelectAccountModel(R.drawable.cardd, "Pettijohn Auto Center", "","SILVER - 3248 8974 9873 5312"))
        showAccounts.add(SelectAccountModel(R.drawable.card2, " ","CashKEY",""))
        val adopter2=SelectAccoutAdapter()
        adopter2.setData(showAccounts)
        rvSelectAccount.adapter=adopter2

        recyclerlist.layoutManager=LinearLayoutManager(requireContext())
        val showList=ArrayList<AccountModel>()
        showList.add(AccountModel("12/28/2020","0 Points", R.drawable.pointsicon,"Complimentary First Lube Oil and Filter"))
        showList.add(AccountModel("12/28/2020","-2500 Points", R.drawable.pointsicon,"Car Wash and Vaccum"))
        showList.add(AccountModel("12/28/2020","+15000 Points", R.drawable.pointsicon,"Parts and Service Purchase"))
        showList.add(AccountModel("12/28/2020","0 Points", R.drawable.pointsicon,"Complimentary First Lube Oil and Filter"))
        showList.add(AccountModel("12/28/2020","0 Points", R.drawable.pointsicon,"Complimentary First Lube Oil and Filter"))
        showList.add(AccountModel("12/28/2020","0 Points", R.drawable.pointsicon,"Complimentary First Lube Oil and Filter"))
        showList.add(AccountModel("12/28/2020","0 Points", R.drawable.pointsicon,"Complimentary First Lube Oil and Filter"))
        showList.add(AccountModel("12/28/2020","0 Points", R.drawable.pointsicon,"Complimentary First Lube Oil and Filter"))
        showList.add(AccountModel("12/28/2020","0 Points", R.drawable.pointsicon,"Complimentary First Lube Oil and Filter"))
        showList.add(AccountModel("12/28/2020","0 Points", R.drawable.pointsicon,"Complimentary First Lube Oil and Filter"))
        val adopter=AccountAdapter()
        adopter.set_Data(showList)
        recyclerlist.adapter=adopter

        return view1

    }


    private fun findView()
    {
        recyclerlist=view1.findViewById(R.id.recyclerList)
        rvSelectAccount=view1.findViewById(R.id.rvSelectAccount)
        ivArrowDown=view1.findViewById(R.id.ivArrowDown)
        ivArrowUp=view1.findViewById(R.id.ivArrowUp)
        cons1=view1.findViewById(R.id.cons1)
        cons2=view1.findViewById(R.id.cons2)
        ivSettingIcon=view1.findViewById(R.id.ivSettingIcon)
       // constraint_ly1=view1.findViewById(R.id.constraint_ly1)
    }

    private fun onClick()
    {
        ivArrowDown.setOnClickListener {
            cons2.setVisibility(View.VISIBLE)
            cons1.setVisibility(View.INVISIBLE)

        }

        /*constraint_ly1.setOnClickListener {
            cons2.setVisibility(View.GONE)
            cons1.setVisibility(View.VISIBLE)
        }*/

        ivArrowUp.setOnClickListener {
            cons2.setVisibility(View.GONE)
            cons1.setVisibility(View.VISIBLE)
        }

        ivSettingIcon.setOnClickListener {

            val intent=Intent(requireContext(),SettingActivity::class.java)
            startActivity(intent)
        }
    }

}