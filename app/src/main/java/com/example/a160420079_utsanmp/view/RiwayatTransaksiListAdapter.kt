package com.example.a160420079_utsanmp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420079_utsanmp.R
import com.example.a160420079_utsanmp.model.RiwayatKost
import com.example.a160420079_utsanmp.model.RiwayatTransaksi
import com.example.a160420079_utsanmp.util.loadImage

class RiwayatTransaksiListAdapter(private val riwayatTransaksi: ArrayList<RiwayatTransaksi>): RecyclerView.Adapter<RiwayatTransaksiListAdapter.RiwayatTransaksiListViewHolder>() {
    class RiwayatTransaksiListViewHolder(var view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatTransaksiListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.riwayattransaksi_layout_item, parent, false)
        return RiwayatTransaksiListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return riwayatTransaksi.size
    }

    override fun onBindViewHolder(holder: RiwayatTransaksiListViewHolder, position: Int) {
        val txtTransaksiKostItem = holder.view.findViewById<TextView>(R.id.txtTransaksiKostItem)
        val txtHargaTransaksiItem = holder.view.findViewById<TextView>(R.id.txtHargaTransaksiItem)
        val txtStatusTransaksiItem = holder.view.findViewById<TextView>(R.id.txtStatusTransaksiItem)
        val imgKostTransaksiItem = holder.view.findViewById<ImageView>(R.id.imgKostTransaksiItem)

        txtTransaksiKostItem.text = riwayatTransaksi[position].nameKost
        txtHargaTransaksiItem.text = "Rp. " + riwayatTransaksi[position].price.toString()
        txtStatusTransaksiItem.text = "Status Pembayaran : " + riwayatTransaksi[position].statusPembayaran
        imgKostTransaksiItem.loadImage(riwayatTransaksi[position].imgUrl)
    }

    fun updateRiwayatTransaksi(newRiwayatTransaksi: ArrayList<RiwayatTransaksi>) {
        riwayatTransaksi.clear()
        riwayatTransaksi.addAll(newRiwayatTransaksi)
        notifyDataSetChanged()
    }
}