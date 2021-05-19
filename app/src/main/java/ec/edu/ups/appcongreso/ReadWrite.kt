package ec.edu.ups.appcongreso

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ReadWrite(val context:Context) {
    fun writeHistory(history: MutableList<String>){
        var sp: SharedPreferences? = context.getSharedPreferences("_history",
            AppCompatActivity.MODE_PRIVATE
        )
        var editor: SharedPreferences.Editor? = sp?.edit()
        var gson = Gson()
        var json: String = gson.toJson(history)

        editor?.putString("history", json)
        editor?.apply()
    }

    fun readHistory(): MutableList<String>{
        var sp: SharedPreferences? = context.getSharedPreferences("_history",
            AppCompatActivity.MODE_PRIVATE
        )
        var gson = Gson()
        var json = sp?.getString("history", null)
        var type = object: TypeToken<MutableList<String>>() {}.type
        return if(json != null) {
            var history: MutableList<String> = gson.fromJson(json, type)
            history
        } else{
            mutableListOf()
        }
    }
}