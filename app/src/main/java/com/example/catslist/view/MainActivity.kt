package com.example.catslist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catslist.R
import com.example.catslist.databinding.ActivityMainBinding
import com.example.catslist.network.RequestEndpoint
import com.example.catslist.network.RetrofitService
import com.example.catslist.view.adapter.ListAdpter
import com.example.catslist.viewmodel.GalleryViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {


    private lateinit var _binding: ActivityMainBinding
    private val binding get()= _binding

    private lateinit  var adapter: ListAdpter
    private val viewModel : GalleryViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ltvcats.layoutManager = LinearLayoutManager(this)

    }

    override fun onResume() {
        super.onResume()

        bringCatsList()
        observe()
    }

    fun bringCatsList(){

        val remote= RetrofitService.createService(RequestEndpoint::class.java)
        val response= remote.sendRequest()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                adapter= ListAdpter(it.data)
                binding.ltvcats.adapter= adapter

            }) { it ->

                it.message?.let {Log.d( getString(R.string.erro_request),it) }

            }
    }

    private fun observe(){

        viewModel.itemsgallery.observe(this){

            adapter.atualizaLista(it)
        }


    }

}