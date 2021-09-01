package com.jmzd.ghazal.kotlinmvvmonlineshop.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jmzd.ghazal.kotlinmvvmonlineshop.R
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ItemsPayBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_Pay
import com.jmzd.ghazal.kotlinmvvmonlineshop.utils.ClickItems

class PayAdapter (val activity: Activity, val array:IntArray, val list: List<DataModel_Pay>, val click: ClickItems) : RecyclerView.Adapter<PayAdapter.viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.items_pay, parent, false))
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val id= View.generateViewId()
        holder.items.RgSelect.id=id
        array[position]=id
        val data=list.get(position)
        holder.items.data=data
        holder.itemView.setOnClickListener {
            click.Click(data.link)
        }
        if(position==1){
            holder.items.RgSelect.isChecked=true
            click.Click(data.link)
        }
        holder.items.RgSelect.setOnClickListener { v->
            for(i in array.indices){
                val rg=(activity).findViewById<RadioButton>(array[i])
                rg.isChecked=v.id==array[i]
            }
            click.Click(data.link)
        }
    }

    class viewholder(val items: ItemsPayBinding) : RecyclerView.ViewHolder(items.root)


}