package com.myapplication.shoppingboss.BottomNavFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.shoppingboss.AdapterClasses.BottomNavAdaptor
import com.myapplication.shoppingboss.AdapterClasses.MessagesAdapter
import com.myapplication.shoppingboss.Fragments.*
import com.myapplication.shoppingboss.ModelClasses.BottomNavModel
import com.myapplication.shoppingboss.R

class MainFragmentNav : AppCompatActivity() {

    lateinit var rvItem: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment_nav)
        supportFragmentManager.beginTransaction().replace(R.id.container,FragmentActivity()).commit()
        rvItem=findViewById(R.id.rvBottoms)


        var itemsBtm = arrayListOf<BottomNavModel>(
            BottomNavModel(
                R.drawable.activity,
                R.drawable.activity2,
                "Activity",
                android.R.color.holo_blue_dark,
                android.R.color.black,
            ),
            BottomNavModel(

                R.drawable.rewards,
                R.drawable.reward2,
                "Reward",
                android.R.color.holo_blue_dark,
                android.R.color.black,
            ),
            BottomNavModel(

                R.drawable.store,
                R.drawable.store2,
                "Store",
                android.R.color.holo_blue_dark,
                android.R.color.black,
            ),

            BottomNavModel(

                R.drawable.message,
                R.drawable.message2,
                "Message",
                android.R.color.holo_blue_dark,
                android.R.color.black,
            ),

            BottomNavModel(

                R.drawable.more,
                R.drawable.more2,
                "More",
                android.R.color.holo_blue_dark,
                android.R.color.black,
            )

        )

        rvItem.adapter = BottomNavAdaptor(itemsBtm, this)
        { prePosition: Int, selectedPost: Int, item: BottomNavModel ->

            if (selectedPost == 0) {
                supportFragmentManager.beginTransaction().replace(R.id.container, FragmentActivity()).commit()
                true
            }
            if (selectedPost == 1) {
                supportFragmentManager.beginTransaction().replace(R.id.container, RewardFragment()).commit()
                true
            }

            if (selectedPost == 2) {
                supportFragmentManager.beginTransaction().replace(R.id.container, StoreFragment()).commit()
                true
            }

            if (selectedPost == 3) {
                supportFragmentManager.beginTransaction().replace(R.id.container, MessageFragment()).commit()
                true
            }

            if (selectedPost == 4) {
                supportFragmentManager.beginTransaction().replace(R.id.container, MoreFragment()).commit()
                true
            }
        }
    }
}