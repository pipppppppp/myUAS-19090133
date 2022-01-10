package com.example.uas19090133.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uas19090133.R
import com.example.uas19090133.model.RComment
import kotlinx.android.synthetic.main.item_post.view.*

class AComment (private val listComment: ArrayList<RComment>): RecyclerView.Adapter<AComment.CommentViewHolder>() {
    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(rComment: RComment){
            with(itemView){
                val text = "postId : ${rComment.postId}\n" +
                        "Id : ${rComment.id}\n" +
                        "Name : ${rComment.name}\n" +
                        "Email : ${rComment.email}\n" +
                        "Body : ${rComment.body}"
                tv_Text.text = text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        //inflate layout item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(listComment[position])
    }

    override fun getItemCount(): Int = listComment.size

}