package com.example.reciclerviewtest

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.music_list_item.view.*

data class Music(val title: String, val artist: String, val year: String)

class MusicAdapter(val items : ArrayList<Music>, val context: Context) : RecyclerView.Adapter<MusicViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MusicViewHolder {
        return MusicViewHolder(LayoutInflater.from(context).inflate(R.layout.music_list_item, parent, false))
    }

    override fun onBindViewHolder(holderMusic: MusicViewHolder?, position: Int) {
        holderMusic?.tvMusicTitle?.text = items.get(position).title
        holderMusic?.tvMusicArtist?.text = items.get(position).artist
        holderMusic?.tvMusicYear?.text = items.get(position).year
    }
}

class MusicViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val tvMusicTitle = view.tv_music_title
    val tvMusicArtist = view.tv_music_artist
    val tvMusicYear = view.tv_music_release
}
