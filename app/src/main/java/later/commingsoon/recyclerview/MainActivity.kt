package later.commingsoon.recyclerview

import android.annotation.TargetApi
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_recycler.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var recyclerView2: RecyclerView
    private lateinit var viewAdapter2: RecyclerView.Adapter<*>
    private lateinit var viewManager2: RecyclerView.LayoutManager

    @TargetApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ArraySuperNama = resources.getStringArray(R.array.Nama)
        var ArraySuperJob = resources.getStringArray(R.array.JobDesk)
        var ArraySuperImage = resources.getStringArray(R.array.ImageUri)
        viewManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        viewAdapter = adapterRecycler(ArraySuperNama,ArraySuperJob,ArraySuperImage,this)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerm_view).apply {
            setHasFixedSize(false)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        viewManager = LinearLayoutManager(this)
        viewAdapter = adapterRecycler(ArraySuperNama,ArraySuperJob,ArraySuperImage,this)

        recyclerView2 = findViewById<RecyclerView>(R.id.recyclerm_view2).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        val tada = View(applicationContext)
        recyclerView2.setOnClickListener(){
            var p = recyclerView2.scrollState
            Toast.makeText(this , p.toString() , Toast.LENGTH_SHORT).show()
        }



    }
}
