package later.commingsoon.recyclerview

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_daftar.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener {
            user_login()
        }
        DaftarBtn.setOnClickListener{
            var pIntent = Intent(this,DaftarActivity::class.java)
            startActivity(pIntent)
        }
    }

    fun user_logged(context:Context) : String{
        var user = PreferenceManager.getDefaultSharedPreferences(context)
        return user.getString("username","")
    }
    fun user_login(){
        val getSharedPref = PreferenceManager.getDefaultSharedPreferences(this)
        var usernamePW = getSharedPref.getString("daftarusername","undefined!!!")
        var passwordPW = getSharedPref.getString("daftarpassword","undefined!!!")
        val editor = getSharedPref.edit()
        println("Username Pw :" + usernamePW)
        if(usernameLog.text.toString().equals(usernamePW)){
            if(passwordLog.text.toString().equals(passwordPW)){
                editor.putString("username",usernamePW)
                editor.putString("password",passwordPW)
                editor.commit()
                var pIntent = Intent(this,MainActivity::class.java)
                startActivity(pIntent)
            }
        }
    }
    fun set_userLogged(username:String,password:String,context:Context){
        val getSharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = getSharedPref.edit()
        editor.putString("daftarusername",username)
        editor.putString("daftarpassword",password)
        editor.commit()
    }
    fun user_destroy(context:Context){
        val getSharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        var usernamePW = getSharedPref.getString("daftarusername","undefined!!!")
        var passwordPW = getSharedPref.getString("daftarpassword","undefined!!!")
        val editor = getSharedPref.edit()
        println("Username Pw :" + usernamePW)
        if(usernameLog.text.toString().equals(usernamePW)){
            if(passwordLog.text.toString().equals(passwordPW)){
                editor.putString("username","")
                editor.putString("password","")
                editor.commit()
                var pIntent = Intent(this,MainActivity::class.java)
                startActivity(pIntent)
            }
        }
    }
}
