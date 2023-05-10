package com.example.a160420079_utsanmp.view

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

class SaveKostAdapter(private val saveKostList: ArrayList<Kost>): RecyclerView.Adapter<SaveKostAdapter.SaveKostViewHolder>() {

    class SaveKostViewHolder(var view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaveKostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.savekost_layout_item, parent, false)
        return SaveKostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return saveKostList.size
    }

    override fun onBindViewHolder(holder: SaveKostViewHolder, position: Int) {
        val txtNamaKostSaveItem = holder.view.findViewById<TextView>(R.id.txtNamaKostSaveItem)
        val txtHargaSaveItem = holder.view.findViewById<TextView>(R.id.txtHargaSaveItem)
        val btnDetailSaveItem = holder.view.findViewById<Button>(R.id.btnDetailSaveItem)
        val imgKostSaveItem = holder.view.findViewById<ImageView>(R.id.imgKostSaveItem)

        txtNamaKostSaveItem.text = saveKostList[position].nameKost
        txtHargaSaveItem.text = "Rp. " + saveKostList[position].price.toString() + " / Month"
        imgKostSaveItem.loadImage(saveKostList[position].imgUrl)

        btnDetailSaveItem?.setOnClickListener{
            val action = SaveKostFragmentDirections.actionKostDetailFromSave(saveKostList[position].id)
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateSaveKost(newKostSayaList: ArrayList<Kost>) {
        saveKostList.clear()
        saveKostList.addAll(newKostSayaList)
        notifyDataSetChanged()
    }
}