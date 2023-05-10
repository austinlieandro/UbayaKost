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
import com.example.a160420079_utsanmp.viewmodel.RiwayatKostViewModel
import com.example.a160420079_utsanmp.viewmodel.RiwayatTransaksiViewModel

class RiwayatTransaksiFragment : Fragment() {
    private val riwayatTransaksiListAdapter = RiwayatTransaksiListAdapter(arrayListOf())
    private lateinit var riwayatTransaksiViewModel: RiwayatTransaksiViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var recView = view?.findViewById<RecyclerView>(R.id.recViewRiwayatTransaksi)
        riwayatTransaksiViewModel = ViewModelProvider(this).get(RiwayatTransaksiViewModel::class.java)
        riwayatTransaksiViewModel.fetch()

        recView?.let {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = riwayatTransaksiListAdapter
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
        return inflater.inflate(R.layout.fragment_riwayat_transaksi, container, false)
    }

    private fun observe(){
        riwayatTransaksiViewModel.riwayatTransaksiLD.observe(viewLifecycleOwner, Observer {
            riwayatTransaksiListAdapter.updateRiwayatTransaksi(it)
        })
    }

}