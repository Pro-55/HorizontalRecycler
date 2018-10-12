package com.example.admin.horizontalrecycler

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class imageListAdapter(private val posts: IntArray, var onClick: OnClickEvent, var context: Context) : RecyclerView.Adapter<imageListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val listImage: AppCompatImageView = itemView.findViewById(R.id.imageListItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_image_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.listImage.setImageResource(posts[position])
        holder.itemView.setOnClickListener {
            onClick.itemOnClick(posts[position])
        }
    }
}
