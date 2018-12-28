package later.commingsoon.recyclerview

import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_extends.*
import kotlinx.android.synthetic.main.activity_recycler.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var recyclerView2: RecyclerView
    private lateinit var viewAdapter2: RecyclerView.Adapter<*>
    private lateinit var viewManager2: RecyclerView.LayoutManager



    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                recyclerView.visibility = View.VISIBLE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                recyclerView.visibility = View.GONE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                val getSharedPref = PreferenceManager.getDefaultSharedPreferences(this)
                val editor = getSharedPref.edit()
                editor.putString("username","")
                editor.commit()
                var pIntent = Intent(applicationContext, SplashActivity::class.java)
                startActivity(pIntent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    @TargetApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var ArraySuperNama = resources.getStringArray(R.array.Nama)
        var ArraySuperJob = resources.getStringArray(R.array.JobDesk)
        var ArraySuperImage = resources.getStringArray(R.array.ImageUri)
        viewManager = LinearLayoutManager(this)
        viewAdapter = adapterRecycler(ArraySuperNama,ArraySuperJob,ArraySuperImage,this)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerm_view).apply {
            setHasFixedSize(false)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
