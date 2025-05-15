package com.example.animelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AnimeAdapter(
    private val animeList: List<Anime>,
    private val onItemClick: (Anime) -> Unit
) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    class AnimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivPoster: ImageView = view.findViewById(R.id.ivPoster)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvDesc: TextView = view.findViewById(R.id.tvDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = animeList[position]
        holder.tvTitle.text = anime.title
        holder.tvDesc.text = anime.description
        Glide.with(holder.itemView.context)
            .load(anime.imageUrl)
            .into(holder.ivPoster)

        holder.itemView.setOnClickListener {
            onItemClick(anime)
        }
    }

    override fun getItemCount() = animeList.size
}
