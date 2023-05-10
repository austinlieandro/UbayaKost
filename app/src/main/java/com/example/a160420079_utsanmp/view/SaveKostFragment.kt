package com.example.a160420079_utsanmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420079_utsanmp.R
import com.example.a160420079_utsanmp.viewmodel.KostViewModel
import com.example.a160420079_utsanmp.viewmodel.SaveKostViewModel

class SaveKostFragment : Fragment() {

    private val saveKostAdapter = SaveKostAdapter(arrayListOf())
    private lateinit var saveKostModel: SaveKostViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var recView = view?.findViewById<RecyclerView>(R.id.recViewSave)
        saveKostModel = ViewModelProvider(this).get(SaveKostViewModel::class.java)
        saveKostModel.fetch()

        recView?.let {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = saveKostAdapter
        }

        observe()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_save_kost, container, false)
    }

    private fun observe(){
        saveKostModel.saveKostLD.observe(viewLifecycleOwner, Observer {
            saveKostAdapter.updateSaveKost(it)
        })
    }
}