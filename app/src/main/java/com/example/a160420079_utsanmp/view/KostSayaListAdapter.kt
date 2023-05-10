package com.example.a160420079_utsanmp.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420079_utsanmp.R
import com.example.a160420079_utsanmp.model.Kost
import com.example.a160420079_utsanmp.util.loadImage

class KostSayaListAdapter(private val kostSayaList: ArrayList<Kost>): RecyclerView.Adapter<KostSayaListAdapter.KostSayaViewHolder>() {

    class KostSayaViewHolder(var view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KostSayaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.kostsaya_layout_item, parent, false)
        return KostSayaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return kostSayaList.size
    }

    override fun onBindViewHolder(holder: KostSayaViewHolder, position: Int) {
        Log.d("TES KOST SAYA", kostSayaList.toString())
        val txtNamaKostSayaItem = holder.view.findViewById<TextView>(R.id.txtNamaKostSayaItem)
        val txtHargaKostSayaItem = holder.view.findViewById<TextView>(R.id.txtHargaKostSayaItem)
        val btnDetailKostSayaItem = holder.view.findViewById<Button>(R.id.btnDetailKostSayaItem)
        val imgKostSayaItem = holder.view.findViewById<ImageView>(R.id.imgKostSayaItem)

        txtNamaKostSayaItem.text = kostSayaList[position].nameKost
        txtHargaKostSayaItem.text = "Rp. " + kostSayaList[position].price.toString() + " / Month"
        btnDetailKostSayaItem?.setOnClickListener{
            val action = KostSayaFragmentDirections.actionKostDetailFromKostSaya(kostSayaList[position].id)
            Navigation.findNavController(it).navigate(action)
        }

        imgKostSayaItem.loadImage(kostSayaList[position].imgUrl)
    }

    fun updateKostSaya(newKostSayaList: ArrayList<Kost>) {
        kostSayaList.clear()
        kostSayaList.addAll(newKostSayaList)
        notifyDataSetChanged()
    }
}