package com.myapplication.shoppingboss.Fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.shoppingboss.AdapterClasses.AccountAdapter
import com.myapplication.shoppingboss.AdapterClasses.MessagesAdapter
import com.myapplication.shoppingboss.ModelClasses.MessagesModel
import com.myapplication.shoppingboss.R

class MessageFragment : Fragment() {
    lateinit var view1: View
    lateinit var recyclerlist:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view1 = inflater.inflate(R.layout.activity_message_fragment, container, false)
        findView()
        recyclerlist.layoutManager= LinearLayoutManager(requireContext())

        val showlist=ArrayList<MessagesModel>()

        showlist.add(MessagesModel(R.drawable.icon,"Pettijohn Auto Center Wishes You Happy Birthday", "2022-11-23 23:12:10"))
        showlist.add(MessagesModel(R.drawable.icon,"Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "2022-11-23 23:12:10"))
        showlist.add(MessagesModel(R.drawable.messages01,"It is a long established fact that a reader will be distracted by the content", "2022-11-23 23:12:10"))
        showlist.add(MessagesModel(R.drawable.messages03,"Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "2022-11-23 23:12:10"))
        showlist.add(MessagesModel(R.drawable.messages01,"Pettijohn Auto Center Wishes You Happy Birthday", "2022-11-23 23:12:10"))
        showlist.add(MessagesModel(R.drawable.icon,"Pettijohn Auto Center Wishes You Happy Birthday", "2022-11-23 23:12:10"))
        showlist.add(MessagesModel(R.drawable.icon,"Pettijohn Auto Center Wishes You Happy Birthday", "2022-11-23 23:12:10"))
        showlist.add(MessagesModel(R.drawable.icon,"Pettijohn Auto Center Wishes You Happy Birthday", "2022-11-23 23:12:10"))
        showlist.add(MessagesModel(R.drawable.icon,"Pettijohn Auto Center Wishes You Happy Birthday", "2022-11-23 23:12:10"))

        val adopter= MessagesAdapter()
        adopter.setDate(showlist)
        recyclerlist.adapter=adopter

        return view1
    }

    private fun findView()
    {
        recyclerlist=view1.findViewById(R.id.rvMessages)
    }
}