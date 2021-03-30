package com.example.wisata

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var dataNama: Array<String>
    private lateinit var dataDeskripsi: Array<String>
    private lateinit var dataFoto: TypedArray
    private lateinit var adapter: WisataAdapter
    private var wisata_ = arrayListOf<Wisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView: ListView = findViewById(R.id.lv_wisata)
        adapter = WisataAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()
    }
    private fun prepare() {
        dataNama = resources.getStringArray(R.array.data_nama)
        dataDeskripsi = resources.getStringArray(R.array.data_deskripsi)
        dataFoto = resources.obtainTypedArray(R.array.data_foto)
    }
    private fun addItem() {
        for (position in dataNama.indices) {
            val wisata = Wisata(
                dataNama[position],
                dataDeskripsi[position],
                dataFoto.getResourceId(position, -1)
            )
            wisata_.add(wisata)
        }
        adapter.wisata = wisata_
    }
}
