package com.myapplication.shoppingboss.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.myapplication.shoppingboss.BottomNavFragment.MainFragmentNav
import com.myapplication.shoppingboss.R
import com.myapplication.shoppingboss.Utlis.SharedPreference
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.json.JSONObject
import java.io.IOException


class Login : AppCompatActivity() {
    lateinit var tvResetPassword: TextView
    lateinit var tvCreateLogin: TextView
    lateinit var btnLoginNow: Button
    lateinit var etEmailAddress:EditText
    lateinit var etPassword:EditText


   val postUrl:String="https://beta-api.loyalty-trac.com/security/oauth/token"
    val postBody:String="{\n" +
            "  \"grant_type\":\"password\",\n"+
    "  \"client_id\":\"plg_android\",\n"+
    "  \"client_secret\":\"!Passw0rd\",\n"+
    "  \"username\":\"mt3223\",\n"+
            "  \"password\":\"test12345\"\n" +
            "}"
    val JSON = "application/json; charset=utf-8".toMediaTypeOrNull()

    var isAllFieldChecked=false
    override fun onCreate(savedInstanceState: Bundle?) {
       window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        try {
            postRequest(postUrl, postBody)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        findView()
        onClickListner()
    }

    fun postRequest(postUrl:String, postBody:String)
    {
        val client = OkHttpClient()
        val body = RequestBody.create(JSON, postBody)
        val request=Request.Builder().url(postUrl).post(body).build()
        client.newCall(request).enqueue(object:Callback{

            override fun onFailure(call: Call, e: IOException) {
                call.cancel()
            }

            override fun onResponse(call: Call, response: Response) {
                    response.body?.let { Log.d("TAG", it.string()) }
                }

        })
    }

    private fun findView()
    {
        tvResetPassword=findViewById(R.id.tvResetPassword)
        tvCreateLogin=findViewById(R.id.tvCreateLogin)
        btnLoginNow=findViewById(R.id.btnLoginNow)
        etEmailAddress=findViewById(R.id.etEmailAddress)
        etPassword=findViewById(R.id.etPassword)
    }

    private fun onClickListner() {
        tvResetPassword.setOnClickListener {
            val intent = Intent(this, ForgotLoginActivity::class.java)
            startActivity(intent)
        }

        tvCreateLogin.setOnClickListener {
            val intent = Intent(this, CreateLoginActivity::class.java)
            startActivity(intent)
        }


        if(SharedPreference.shared.islogin==true) {
            startActivity(Intent(this, MainFragmentNav::class.java))
            finish()
        }


            btnLoginNow.setOnClickListener {
                SharedPreference.shared.islogin = true
                isAllFieldChecked = ChecksField()
                if (isAllFieldChecked) {
                    val intent = Intent(this, MainFragmentNav::class.java)
                    startActivity(intent)
                    finishAffinity()
                }
            }
    }

    private fun ChecksField(): Boolean {
        if (etEmailAddress.text.isEmpty() || !etEmailAddress.text.toString().matches(Patterns.EMAIL_ADDRESS.toRegex())){
            etEmailAddress.error="Invalid Email address"
            return false

    }

        if(etPassword.length()==0){
            etPassword.error="This field is required"
            return false

        } else if(etPassword.length()<8){
            etPassword.error="Password must contain 8 character"
            return false
        }

        return true
}
}