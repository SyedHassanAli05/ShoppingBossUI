package com.myapplication.shoppingboss.Fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.shoppingboss.AdapterClasses.StoreSalesAdapter
import com.myapplication.shoppingboss.AdapterClasses.StoreServiceAdapter
import com.myapplication.shoppingboss.ModelClasses.StoreSalesModel
import com.myapplication.shoppingboss.ModelClasses.StoreServiceModel
import com.myapplication.shoppingboss.R

class StoreFragment : Fragment() {
    lateinit var view1: View
    lateinit var rvStoreSales:RecyclerView
    lateinit var rvStoreService:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        view1 = inflater.inflate(R.layout.activity_store_fragment, container, false)
        findView()
        rvStoreSales.layoutManager=LinearLayoutManager(requireContext())
        val showSales=ArrayList<StoreSalesModel>()
        showSales.add(StoreSalesModel("Mon/Tue/Wed/Fri: 8:00am to 5:00pm"))
        showSales.add(StoreSalesModel("Thu: 8:00am to 7:00pm"))
        showSales.add(StoreSalesModel("Sat: 8:00am to 2:00pm"))
        val adopter=StoreSalesAdapter()
        adopter.setSaleData(showSales)
        rvStoreSales.adapter=adopter

        rvStoreService.layoutManager=LinearLayoutManager(requireContext())
        val showService=ArrayList<StoreServiceModel>()
        showService.add(StoreServiceModel("Mon-Fri: 7:30am to 5:00pm"))
        showService.add(StoreServiceModel("Mon-Fri: 7:30am to 5:00pm"))
        val adopter2=StoreServiceAdapter()
        adopter2.setServiceData(showService)
        rvStoreService.adapter=adopter2
        return view1
    }

    private fun findView()
    {
       rvStoreSales=view1.findViewById(R.id.rvStoreSales)
        rvStoreService=view1.findViewById(R.id.rvStoreService)
    }
}