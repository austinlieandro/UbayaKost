package com.example.a160420079_utsanmp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420079_utsanmp.R
import com.example.a160420079_utsanmp.model.Kost
import com.example.a160420079_utsanmp.model.RiwayatKost
import com.example.a160420079_utsanmp.util.loadImage

class RiwayatKostListAdapter(private val riwayatKostList: ArrayList<RiwayatKost>): RecyclerView.Adapter<RiwayatKostListAdapter.RiwayatKostViewHolder>() {
    class RiwayatKostViewHolder(var view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatKostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.riwayatkost_layout_item, parent, false)
        return RiwayatKostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return riwayatKostList.size
    }

    override fun onBindViewHolder(holder: RiwayatKostViewHolder, position: Int) {
        val txtNamaRiwayatKostItem = holder.view.findViewById<TextView>(R.id.txtNamaRiwayatKostItem)
        val txtDurasiKostItem = holder.view.findViewById<TextView>(R.id.txtDurasiKostItem)
        val txtRiwayatAlamatItem = holder.view.findViewById<TextView>(R.id.txtRiwayatAlamatItem)
        val imgRiwayatKostItem = holder.view.findViewById<ImageView>(R.id.imgRiwayatKostItem)

        txtNamaRiwayatKostItem.text = riwayatKostList[position].nameKost
        txtDurasiKostItem.text = "Durasi : " + riwayatKostList[position].durasi.toString() + " Bulan"
        txtRiwayatAlamatItem.text = riwayatKostList[position].alamat
        imgRiwayatKostItem.loadImage(riwayatKostList[position].imgUrl)
    }

    fun updateRiwayatKost(newRiwayatKost: ArrayList<RiwayatKost>) {
        riwayatKostList.clear()
        riwayatKostList.addAll(newRiwayatKost)
        notifyDataSetChanged()
    }
}