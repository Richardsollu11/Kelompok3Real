package com.example.wisata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class WisataAdapter constructor(private val context: Context) : BaseAdapter(){

    internal var wisata = arrayListOf<Wisata>()
    override fun getCount(): Int = wisata.size

    override fun getItem(i: Int): Any = wisata[i]

    override fun getItemId(i: Int): Long = i.toLong()
    override fun getView(position: Int, v: View?, viewGroup: ViewGroup): View {
        var itemView = v
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_wisata, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val _wisata = getItem(position) as Wisata
        viewHolder.bind(_wisata)
        return itemView
    }
    private inner class ViewHolder constructor(view: View) {
        private val tvNama: TextView = view.findViewById(R.id.tv_nama)
        private val tvDeskripsi: TextView = view.findViewById(R.id.tv_deskripsi)
        private val imgFoto: ImageView = view.findViewById(R.id.img_item_photo)
        fun bind(wisata: Wisata) {
            tvNama.text = wisata.nama
            tvDeskripsi.text = wisata.deskripsi
            imgFoto.setImageResource(wisata.foto)
        }
    }
}
