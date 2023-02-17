package com.myapplication.shoppingboss.Fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.myapplication.shoppingboss.Activities.PrivacyPolicyActivity
import com.myapplication.shoppingboss.R

class MoreFragment :  Fragment() {
    lateinit var view1: View
    lateinit var tvPrivacyPolicy:TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        view1 = inflater.inflate(R.layout.activity_more_fragment, container, false)
        findView()
        onClick()
        return view1
    }

    private fun findView()
    {
        tvPrivacyPolicy=view1.findViewById(R.id.tvPrivacyPolicy)

    }

    private fun onClick()
    {
        tvPrivacyPolicy.setOnClickListener {
           val intent=Intent(requireContext(),PrivacyPolicyActivity::class.java)
            startActivity(intent)
        }
    }


}