package com.example.imageviewer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class ImageAdapter(private val imagelist:ArrayList<Int>,private val viewPager2: ViewPager2)

    :RecyclerView.Adapter<ImageAdapter.ImageviewHolder>(){
class  ImageviewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val imageview: ImageView =itemView.findViewById(R.id.imageView);
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageviewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.image_container,parent,false)
        return ImageviewHolder(view)
    }

    override fun getItemCount(): Int {
        return imagelist.size
    }

    override fun onBindViewHolder(holder: ImageviewHolder, position: Int) {
        holder.imageview.setImageResource(imagelist[position])
        if(position==imagelist.size-1){
            viewPager2.post(runnable)
        }
    }
    private val runnable= Runnable {
        imagelist.addAll(imagelist)
        notifyDataSetChanged()
    }
}