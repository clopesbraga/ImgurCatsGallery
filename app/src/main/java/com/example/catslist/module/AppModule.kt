package com.example.catslist.module

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.catslist.viewmodel.GalleryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule= module {

    viewModel{ GalleryViewModel((get())) }

}