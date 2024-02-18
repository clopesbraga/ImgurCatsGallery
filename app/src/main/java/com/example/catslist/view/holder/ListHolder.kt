package com.example.catslist.view.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.catslist.databinding.RowOfCatsBinding
import com.example.catslist.model.Data
import com.example.catslist.utils.CarregaImagem

class ListHolder(val bind: RowOfCatsBinding): RecyclerView.ViewHolder(bind.root) {

    fun bind(repo: Data) = bind.imgCats1.CarregaImagem(repo.images[0].link)

}