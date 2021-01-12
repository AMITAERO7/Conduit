package com.hackernight.conduit.ui.feed

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hackernight.api.model.entities.Article
import com.hackernight.conduit.R

class ArticleFeedAdapter : ListAdapter<Article, ArticleFeedAdapter.ArticleViewHolder>(
    object : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.toString() == newItem.toString()
    }
}
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.list_item_articke,parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = getItem(position)
        holder.apply {
            authorTextView.text = article.author.username
            titleTextView.text = article.title
            bodyTextView.text = article.body
            dateTextView.text = "15-Dec-20"
            avatarImageView.background = ColorDrawable(Color.BLUE)
        }
    }

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
       val authorTextView : TextView =  itemView.findViewById(R.id.authorTextView)
       val titleTextView : TextView = itemView.findViewById(R.id.titleTextView)
       val bodyTextView : TextView = itemView.findViewById(R.id.bodyTextView)
        val dateTextView : TextView = itemView.findViewById(R.id.dateTextView)
        val avatarImageView : ImageView = itemView.findViewById(R.id.avatarImageView)
    }
}