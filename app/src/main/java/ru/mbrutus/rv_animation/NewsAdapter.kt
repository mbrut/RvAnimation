package ru.mbrutus.rv_animation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil

import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_news.*

class NewsAdapter(private val mData: List<NewsItem>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(), Filterable {
    private var mDataFiltered: List<NewsItem> = mData

    override fun getFilter(): Filter {
        return object: Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint?.toString()
                val results = FilterResults()
                results.values = if (query.isNullOrBlank()) { mData }
                else { mData.filter { it.title.toLowerCase().contains(query.toLowerCase()) } }
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                mDataFiltered = results?.values as List<NewsItem>
                val diffCallback = object: DiffUtil.Callback() {
                    override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean = mData[oldPos].id == mDataFiltered[newPos].id

                    override fun areContentsTheSame(oldPos: Int, newPos: Int): Boolean = mData[oldPos].hashCode() == mDataFiltered[newPos].hashCode()

                    override fun getOldListSize(): Int = mData.size

                    override fun getNewListSize(): Int = mDataFiltered.size
                }
                val diffResult = DiffUtil.calculateDiff(diffCallback)
                diffResult.dispatchUpdatesTo(this@NewsAdapter)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return mDataFiltered.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(mDataFiltered[position])
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bind(news: NewsItem) {
            img_user.animation = AnimationUtils.loadAnimation(itemView.context, R.anim.fade_transition_animation)
            card_container.animation = AnimationUtils.loadAnimation(itemView.context, R.anim.fade_scale_animation)

            tv_title.text = news.title
            tv_content.text = news.content
            tv_date.text = news.date
            img_user.setImageResource(news.userPhoto)
        }

    }
}