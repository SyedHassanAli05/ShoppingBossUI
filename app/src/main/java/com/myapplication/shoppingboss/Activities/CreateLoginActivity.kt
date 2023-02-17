package com.myapplication.shoppingboss.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.myapplication.shoppingboss.R

class CreateLoginActivity : AppCompatActivity() {

    lateinit var ivBackIcon:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_login)

        findView()
        onBackPress()
    }

    private fun findView()
    {
        ivBackIcon=findViewById(R.id.ivBackIcon)
    }

    private fun onBackPress()
    {
        ivBackIcon.setOnClickListener {
            onBackPressed()
        }
    }
}