package app.itunes.play.presentation.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import app.itunes.play.R
import app.itunes.play.data.model.Entry
import app.itunes.play.data.model.Feed
import app.itunes.play.databinding.SongsListItemBinding
import app.itunes.play.presentation.activity.SongsDetailsActivity
import app.itunes.play.presentation.viewmodel.SongsListViewModel
import com.bumptech.glide.Glide
import com.google.gson.Gson

class SongsListRecyclerviewAdapter(
    var list: List<Entry>?,
    var viewModel: SongsListViewModel,
) : RecyclerView.Adapter<SongsListRecyclerviewAdapter.SongsListViewHolder>() {


    inner class SongsListViewHolder(binding: SongsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val binding: SongsListItemBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsListViewHolder {
        val binding: SongsListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.songs_list_item, parent, false
        )
        return SongsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SongsListViewHolder, position: Int) {
        val entryItem = list?.get(position)
        holder.binding.item = entryItem
        if (!list?.get(position)?.imageUrl.isNullOrEmpty()) {
            Glide.with(holder.binding.imvIcon.context.applicationContext)
                .load(list?.get(position)?.imageUrl)
                .into(holder.binding.imvIcon)
        }

        holder.binding.clItem.setOnClickListener {
            holder.binding.clItem.context.startActivity(
                Intent(
                    holder.binding.clItem.context,
                    SongsDetailsActivity::class.java
                ).putExtra(
                    "entryItem", Gson().toJson(entryItem)
                )
            )
        }

    }

    override fun getItemCount(): Int {
        return list?.size?:0
    }
}