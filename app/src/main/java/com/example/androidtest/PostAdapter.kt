package com.example.androidtest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//private val posts : List<PostData>, private val postfield : List<Post>
class PostAdapter(
    private val context: Context,
    private val post: List<Post>,
    private val onLikeListener: Boolean
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        val postname = v.findViewById<TextView>(R.id.postname)
        val posttime = v.findViewById<TextView>(R.id.posttime)
        val likecount = v.findViewById<TextView>(R.id.likecount)
        val message = v.findViewById<TextView>(R.id.messagetext)
        val postDescription = v.findViewById<TextView>(R.id.postdescription)
        val postimage = v.findViewById<ImageView>(R.id.postimage)
        val postlike = v.findViewById<ImageView>(R.id.likepost)
        val postmsg = v.findViewById<ImageView>(R.id.postmsg)
        val postshare = v.findViewById<ImageView>(R.id.postshare)
        val postsave = v.findViewById<ImageView>(R.id.postsave)
        val posticon = v.findViewById<ImageView>(R.id.logoutpostimag)

        init {
            v.setOnClickListener {
                if (onLikeListener == true) {
                    postlike.setBackgroundColor(R.color.red)
                } else {
                    postlike.setBackgroundColor(R.color.white)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.postitem, null, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return post.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val postlist = post[position]
//        val fields= postfield[position]
//        holder.postname.text = postlist.u
//        holder.posttime.text =  postlist.createdAt
        holder.postDescription.text = postlist.description

    }
}