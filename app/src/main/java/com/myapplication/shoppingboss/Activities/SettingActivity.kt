package com.myapplication.shoppingboss.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.myapplication.shoppingboss.R
import com.myapplication.shoppingboss.Utlis.SharedPreference

class SettingActivity : AppCompatActivity() {

    lateinit var changePassword:TextView
    lateinit var tvLogout:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        findView()
        onClick()
    }

    private fun findView()
    {
        changePassword=findViewById(R.id.tvChangePassword)
        tvLogout=findViewById(R.id.tvLogout)

    }

    private fun onClick()
    {
        changePassword.setOnClickListener {
            val intent=Intent(this,ChangePasswordActivity::class.java)
            startActivity(intent)
        }

        tvLogout.setOnClickListener {

          SharedPreference.shared.clear()
            val intent=Intent(this,Login::class.java)
            startActivity(intent)
            finishAffinity()

        }
    }
}