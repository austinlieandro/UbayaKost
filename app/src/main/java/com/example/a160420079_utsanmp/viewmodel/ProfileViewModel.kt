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
import com.example.a160420079_utsanmp.model.Profile
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProfileViewModel(application: Application): AndroidViewModel(application) {
    val profileLD = MutableLiveData<Profile>()
    val TAG ="VolleyTag"

    private var queue: RequestQueue? = null

    fun fetch(id: Int) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/ANMP/profile.php?id=$id"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<Profile>() {}.type
                val result = Gson().fromJson<Profile>(it, sType)
                profileLD.value = result

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