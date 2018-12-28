package later.commingsoon.recyclerview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log

class SplashActivity : AppCompatActivity() {

    //Splash activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        runOnUiThread{
            var getUser:String? = LoginActivity().user_logged(this)
            Log.i("Data User : ",getUser)
            if(getUser.equals("")){
                var pIntent = Intent(this,LoginActivity::class.java)
                Handler().postDelayed({
                    startActivity(pIntent)
                    this.finish()
                },2000)
            }else{
                var pIntent = Intent(this,MainActivity::class.java)
                Handler().postDelayed({
                    startActivity(pIntent)
                    this.finish()
                },2000)
            }
        }
    }
}
