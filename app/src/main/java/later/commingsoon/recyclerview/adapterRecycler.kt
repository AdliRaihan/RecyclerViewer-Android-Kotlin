package later.commingsoon.recyclerview

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import later.commingsoon.recyclerview.R.id.search_go_btn
import org.w3c.dom.Text


class adapterRecycler(private val item:Array<String>, val job:Array<String>,val imagesUri:Array<String>,val asConte:Context) : RecyclerView.Adapter<adapterRecycler.ViewHolder>() {
    var pos_2 = 0
    var testoUri = "https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg"
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textResi =  itemView.findViewById<TextView>(R.id.sub_text_recy)
        val textJob =  itemView.findViewById<TextView>(R.id.job_text_recy)
        val maImage = itemView.findViewById<ImageView>(R.id.sub_images_recy)
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): adapterRecycler.ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.activity_recycler,p0,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(p0: adapterRecycler.ViewHolder, p1: Int) {
        p0.textResi.text = item[p1]
        p0.textJob.text = job[getPositionJob()]
        p0.textJob.setOnClickListener() {
            p0.textJob.text = "ha"
        }

        Glide.with(asConte)
            .asBitmap()
            .load(imagesUri.get(p1))
            .into(p0.maImage)
    }

    fun getPositionJob() : Int{
        pos_2 += 1
        if(pos_2 >  3)
            pos_2 = 0

        return pos_2
    }
}