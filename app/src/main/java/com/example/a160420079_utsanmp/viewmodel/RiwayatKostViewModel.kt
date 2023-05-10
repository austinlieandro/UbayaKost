package com.example.a160420079_utsanmp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160420079_utsanmp.model.Kost
import com.example.a160420079_utsanmp.model.RiwayatKost
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RiwayatKostViewModel(application: Application): AndroidViewModel(application) {
    val riwayatKostLD = MutableLiveData<ArrayList<RiwayatKost>>()
    val TAG ="VolleyTag"

    private var queue: RequestQueue? = null

    fun fetch() {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/ANMP/riwayatKost.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<RiwayatKost>>() { }.type
                val result = Gson().fromJson<ArrayList<RiwayatKost>>(it, sType)
                riwayatKostLD.value = result

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}