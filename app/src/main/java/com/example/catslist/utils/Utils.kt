package com.example.catslist.utils

import android.widget.ImageView
import coil.load
import com.example.catslist.R

fun ImageView.CarregaImagem(url: String?= null){
        load(url) {
            fallback(R.drawable.ic_launcher_foreground)
            error(R.drawable.ic_launcher_foreground)
            placeholder(R.drawable.ic_launcher_foreground)
        }
    }
