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
import com.example.a160420079_utsanmp.viewmodel.KostSayaViewModel
import com.example.a160420079_utsanmp.viewmodel.RiwayatKostViewModel

class RiwayatKostFragment : Fragment() {
    private val riwayatKostListAdapter = RiwayatKostListAdapter(arrayListOf())
    private lateinit var riwayatKostViewModel: RiwayatKostViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var recView = view?.findViewById<RecyclerView>(R.id.recViewRiwayatKost)
        riwayatKostViewModel = ViewModelProvider(this).get(RiwayatKostViewModel::class.java)
        riwayatKostViewModel.fetch()

        recView?.let {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = riwayatKostListAdapter
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
        return inflater.inflate(R.layout.fragment_riwayat_kost, container, false)
    }

    private fun observe(){
        riwayatKostViewModel.riwayatKostLD.observe(viewLifecycleOwner, Observer {
            riwayatKostListAdapter.updateRiwayatKost(it)
        })
    }
}