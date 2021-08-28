package com.jmzd.ghazal.kotlinmvvmonlineshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jmzd.ghazal.kotlinmvvmonlineshop.R
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ItemsOrderBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_Order
import com.jmzd.ghazal.kotlinmvvmonlineshop.utils.ClickItems

class UserOrderHistoryAdapter (val list : List<DataModel_Order>, val click: ClickItems) : RecyclerView.Adapter<UserOrderHistoryAdapter.viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.items_order, parent, false))
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val data=list.get(position)
        holder.items.data=data  // set data binding to xml
        if(data.status.equals("1")){
            holder.items.BtnOk.visibility= View.VISIBLE
            holder.items.BtnNo.visibility=View.GONE
        }else
        {
            holder.items.BtnNo.visibility=View.VISIBLE
            holder.items.BtnOk.visibility=View.GONE

        }

        holder.itemView.setOnClickListener {
            click.Click(data.id)
        }
    }

    class viewholder(val items:ItemsOrderBinding) : RecyclerView.ViewHolder(items.root)


}