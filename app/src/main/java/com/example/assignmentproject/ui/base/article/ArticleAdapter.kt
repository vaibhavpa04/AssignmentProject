package com.example.assignmentproject.ui.base.article

import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignmentproject.R
import com.example.assignmentproject.data.model.ResponseHandler
import com.example.assignmentproject.data.model.User
import com.example.assignmentproject.utils.common.TimeUtils
import kotlinx.android.synthetic.main.list_item.view.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class ArticleAdapter(private val articleList : ArrayList<ResponseHandler>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>()    {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return articleList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(articleList[position],position)
    }

    fun addArticles(articls: List<ResponseHandler>) {
        this.articleList.apply {
            clear()
            addAll(articls)
        }
    }

    inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bind(articleList: ResponseHandler,position: Int){
            itemView.apply {
                text_user_name.text =
                    """${articleList.user?.get(position)?.name} ${articleList.user?.get(position)?.lastname}"""
                text_user_designation.text = articleList.user?.get(position)?.designation
                //val date:Date= Date.parse(articleList.user?.get(position)?.createdAt)
                //var time_converted = TimeUtils.getTimeAgo(date)
                text_time.text = articleList.user?.get(position)?.createdAt
                text_article_content.text = articleList.content
                text_article_title.text = articleList.media?.get(position)?.title
                text_article_url.text = articleList.media?.get(position)?.url
                text_article_comment.text = articleList.comments.toString()
                text_article_likes.text = TimeUtils.withSuffix(articleList.likes!!.toLong())
                Glide.with(image_profile.context)
                    .load(articleList.user?.get(position)?.avatar)
                    .into(image_profile)
                Glide.with(image_article.context)
                     .load(articleList.media?.get(position)?.image)
                     .into(image_article)

            }
        }
    }
}