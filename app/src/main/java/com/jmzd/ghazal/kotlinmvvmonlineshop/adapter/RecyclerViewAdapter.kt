package com.jmzd.ghazal.kotlinmvvmonlineshop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jmzd.ghazal.kotlinmvvmonlineshop.R
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ItemsBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_PostItem
import com.jmzd.ghazal.kotlinmvvmonlineshop.utils.ClickItems

class RecyclerViewAdapter(val list : List<DataModel_PostItem>,val click: ClickItems) : RecyclerView.Adapter<RecyclerViewAdapter.viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.items,parent,false))
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val data=list.get(position)
        holder.items.data=data
        holder.items.TvPrice.text=data.price + " تومان "
        holder.items.TvDate.text=" تاریخ "+data.date

        holder.itemView.setOnClickListener {
            click.Click(data.id)
        }
    }

    class viewholder(val items: ItemsBinding) : RecyclerView.ViewHolder(items.root)
//ItemsBinding = come from xml file's name

}