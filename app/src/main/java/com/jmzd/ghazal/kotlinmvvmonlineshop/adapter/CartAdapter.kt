package com.jmzd.ghazal.kotlinmvvmonlineshop.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jmzd.ghazal.kotlinmvvmonlineshop.R
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ItemsCartBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_Cart
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Api
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Repositry
import io.reactivex.disposables.CompositeDisposable

class CartAdapter (val context: Context, val list: List<DataModel_Cart>, val change: GetChangeItems, val user: String) : RecyclerView.Adapter<CartAdapter.viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.items_cart, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val data=list.get(position)
        holder.items.data=data
        holder.items.TvTitle.text=data.title
        holder.items.TvPrice.text=data.price + " تومان "
        holder.items.TvCount.text= " تعداد: "+data.count
        Glide.with(context).load(data.imageurl).into(holder.items.ImPost)

        holder.items.ImMines.setOnClickListener {
            val Com = CompositeDisposable() // میشد این قسمت ها را هم با mutableLiveData و ... پیاده سازی کرد.
            Repositry.CustomResponse.request(Api.invoke().addCart(data.idproduct,"1",user,"m"),Com){
                Log.e("mosbar",it.status)
                if(it.status.equals("ok")){
                    holder.items.TvPrice.text=it.price[0].price + " تومان "

                    change.getChange()
                }
            }
        }

        holder.items.ImMosbat.setOnClickListener {
            val Com = CompositeDisposable()
            Repositry.CustomResponse.request(Api.invoke().addCart(data.idproduct,"1",user,"add"),Com){
                if(it.status.equals("ok")){
                    Log.e("mosbar",it.status)
                    holder.items.TvPrice.text=it.price[0].price + " تومان "
                    change.getChange()
                }
            }

        }


    }

    interface GetChangeItems{ // برای زمانی که آیتمی را حذف یا اضافه می کنیم از سبد خرید و باید به ما اطلاع داده شود چون مجموع قیمت تغییر می کند.
        fun getChange()
    }

    class viewholder(val items: ItemsCartBinding) : RecyclerView.ViewHolder(items.root)


}