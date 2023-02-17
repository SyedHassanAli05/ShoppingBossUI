package com.myapplication.shoppingboss.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.myapplication.shoppingboss.R

class ChangePasswordActivity : AppCompatActivity() {

    lateinit var ivBackIcon:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        findView()
        onClick()
    }

    private fun findView()
    {
        ivBackIcon=findViewById(R.id.ivBackIcon)

    }

    private fun onClick()
    {
        ivBackIcon.setOnClickListener {
           onBackPressed()
        }
    }
}