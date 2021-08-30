package com.jmzd.ghazal.kotlinmvvmonlineshop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jmzd.ghazal.kotlinmvvmonlineshop.R
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ItemsAddressBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_Address

class AddressAdapter (val list : List<DataModel_Address>,val click:Clickaddress) : RecyclerView.Adapter<AddressAdapter.viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.items_address, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return  list.size
    }
    interface Clickaddress{
        fun addressid(id:String)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val data=list.get(position)
        holder.items.data=data
        holder.itemView.setOnClickListener {
            click.addressid(data.id)
        }
    }

    class viewholder(val items:ItemsAddressBinding) : RecyclerView.ViewHolder(items.root)


}