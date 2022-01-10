package com.example.uas19090133.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uas19090133.R
import com.example.uas19090133.model.RPost
import kotlinx.android.synthetic.main.item_post.view.*

class APost(private val list: ArrayList<RPost>): RecyclerView.Adapter<APost.PostViewHolder>(){
    inner class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        // untuk send data ke layout
        fun bind(postRes: RPost){
            with(itemView){
                val text = "User Id : ${postRes.userId}\n" +
                        "id: ${postRes.id}\n" +
                        "title: ${postRes.title}\n" +
                        "text: ${postRes.text}"

                tv_Text.text = text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }

    // untuk get count list nya
    override fun getItemCount(): Int = list.size
}