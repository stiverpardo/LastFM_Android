package com.mistpaag.lastfm.trainee.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.mistpaag.lastfm.trainee.R
import com.mistpaag.lastfm.trainee.models.database.TopArtist
import com.mistpaag.lastfm.trainee.utils.inflate
import kotlinx.android.synthetic.main.top_artist_item.view.*

class TopArtistAdapter(val itemClick:(TopArtist)-> Unit) : ListAdapter<TopArtist, TopArtistAdapter.ViewHolder>(TopArtistDiffCallback()){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.top_artist_item), itemClick = itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(getItem(position), position)
    }

    inner class ViewHolder( itemView: View, var itemClick:(TopArtist)-> Unit) : RecyclerView.ViewHolder(itemView){
        fun bindTo(topArtist: TopArtist, position: Int){
            with(topArtist){
                itemView.artist_image.load(image)
                itemView.artist_image.scaleType = ImageView.ScaleType.CENTER_CROP
                itemView.artist_name.text = name
                itemView.listeners_count.text = "$listeners Listeners"
                itemView.setOnClickListener {
                    itemClick(topArtist)
                }
            }

        }
    }

}



class TopArtistDiffCallback : DiffUtil.ItemCallback<TopArtist>() {
    override fun areItemsTheSame(oldItem: TopArtist, newItem: TopArtist): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: TopArtist, newItem: TopArtist): Boolean {
        return oldItem == newItem
    }
}
