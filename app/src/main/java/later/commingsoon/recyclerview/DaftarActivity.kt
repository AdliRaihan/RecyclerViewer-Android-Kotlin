package later.commingsoon.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_daftar.*
import kotlinx.android.synthetic.main.activity_login.*

class DaftarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        btnDaftar.setOnClickListener {
            if(daftarusernameLog.text.isEmpty()
                    || daftarpasswordLog.text.isEmpty()
                    || daftarpasswordConfLog.text.isEmpty()){
                Toast.makeText(this,"Isi seluruh data yang di perlukan.",Toast.LENGTH_SHORT).show()
            }else{
                if(daftarpasswordLog.text.toString().equals(daftarpasswordConfLog.text.toString())){
                    LoginActivity().set_userLogged(daftarusernameLog.text.toString(),daftarpasswordLog.text.toString(),this)
                    finish()
                }else{
                    Toast.makeText(this,"Konfirmasi password berbeda",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
