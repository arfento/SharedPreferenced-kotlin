package com.ims.sharedpreferenced_kotlin

import android.content.Context

class PreferencesProvider (context: Context) {

    private val sharedPreferences = context.getSharedPreferences("myPreferences", 0)

    //save boolean values into the shared preferences
    fun putBoolean(key : String, value : Boolean){
        sharedPreferences.edit().putBoolean(key, value).apply()
    }
    fun getBoolean(key : String) : Boolean{
        return sharedPreferences.getBoolean(key, false)
    }

    //save string values into the shared preferences
    fun putString(key : String, value : String){
        sharedPreferences.edit().putString(key, value).apply()
    }
    fun getString(key : String) : String?{
        return sharedPreferences.getString(key, null)
    }

    //save int values into the shared preferences
    fun putInteger(key : String, value : Int){
        sharedPreferences.edit().putInt(key, value).apply()
    }
    fun getInteger(key : String) : Int{
        return sharedPreferences.getInt(key, 0)
    }

    //clear sharedpreferenced

    fun clear(){
        sharedPreferences.edit().clear().apply()
    }



}