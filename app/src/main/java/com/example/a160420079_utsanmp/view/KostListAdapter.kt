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

class KostListAdapter(private val kostList: ArrayList<Kost>): RecyclerView.Adapter<KostListAdapter.KostViewHolder>() {

    class KostViewHolder(var view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.home_layout_item, parent, false)
        return KostViewHolder(view)
    }

    override fun onBindViewHolder(holder: KostViewHolder, position: Int) {
        Log.d("TES ITEM", kostList.toString())
        val txtNamaKostItem = holder.view.findViewById<TextView>(R.id.txtNamaKostItem)
        val txtHargaKostItem = holder.view.findViewById<TextView>(R.id.txtHargaKostItem)
        val btnDetailKostItem = holder.view.findViewById<Button>(R.id.btnDetailKostItem)
        val imgKostItem = holder.view.findViewById<ImageView>(R.id.imgKostItem)

        txtNamaKostItem.text = kostList[position].nameKost
        txtHargaKostItem.text = "Rp. " + kostList[position].price.toString() + " / Month"
        btnDetailKostItem?.setOnClickListener{
            val action = HomeFragmentDirections.actionKostDetailFromHome(kostList[position].id)
            Navigation.findNavController(it).navigate(action)
        }

        imgKostItem.loadImage(kostList[position].imgUrl)
    }

    override fun getItemCount(): Int {
        return kostList.size
    }

    fun updateKost(newKostList: ArrayList<Kost>) {
        kostList.clear()
        kostList.addAll(newKostList)
        notifyDataSetChanged()
    }
}