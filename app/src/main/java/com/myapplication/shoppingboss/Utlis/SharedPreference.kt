package com.myapplication.shoppingboss.Utlis

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.core.content.edit


class SharedPreference(private val mContext: Context?) {
    private var preferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    fun clear() {
        preferences?.edit {
            clear()
        }
    }


    var islogin:Boolean
        get(){

            return preferences?.getBoolean("Login", false)?:false
        }
        set(isLogin){
            editor?.apply{
                putBoolean("Login",isLogin)
                apply()
            }
        }




    companion object {
        @JvmField
        var shared = SharedPreference(BaseApplication.instance)
    }


    init {
        preferences = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            mContext?.getSharedPreferences(
                BaseApplication.instance?.packageName, Context.MODE_PRIVATE
            )
        } else {
            mContext?.getSharedPreferences(
                BaseApplication.instance?.packageName, Context.MODE_PRIVATE
            )
        }
        editor = preferences?.edit()
        editor?.apply()
    }

}