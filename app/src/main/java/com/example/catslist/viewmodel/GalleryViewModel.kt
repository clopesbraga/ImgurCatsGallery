package com.example.catslist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.catslist.model.CatsListModel
import com.example.catslist.model.Data

class GalleryViewModel(application: Application): AndroidViewModel(application) {

    private  var  listgallery = MutableLiveData<List<Data>>()

    val itemsgallery: LiveData<List<Data>> get()=listgallery


}