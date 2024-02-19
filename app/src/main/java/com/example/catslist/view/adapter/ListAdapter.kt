package com.example.catslist.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catslist.databinding.RowOfCatsBinding
import com.example.catslist.model.CatsListModel
import com.example.catslist.model.Data
import com.example.catslist.view.holder.ListHolder

class ListAdpter(itemsList: MutableList<Data>): RecyclerView.Adapter<ListHolder>() {

    private var repoList: List<Data> = itemsList


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {

        val item = RowOfCatsBinding.inflate(
            LayoutInflater.from
                (parent.context), parent, false
        )

        return ListHolder(item)

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ListHolder, position: Int) {


        holder.bind(repoList[position])

    }

    override fun getItemCount(): Int {

        return repoList.count()
    }

    fun atualizaLista(list: List<Data>):List<Data>{

        repoList = list
        notifyDataSetChanged()
        return repoList
    }

}