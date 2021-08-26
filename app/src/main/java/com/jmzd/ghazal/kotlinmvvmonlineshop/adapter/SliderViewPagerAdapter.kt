package com.jmzd.ghazal.kotlinmvvmonlineshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.jmzd.ghazal.kotlinmvvmonlineshop.R
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ItemsSliderBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.Slider

class SliderViewPagerAdapter (val list:List<Slider>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object` // ویو را برابربا آبجکت قرار می دهیم که به این معنی است که باید destroy هم بشود. در متد destroy
    }
    override fun getCount(): Int {
        return list.size // لیستی از استرینگ ها که همان عکسها هستند را دریافت میکنیم که طبیعتا باید سایز آنها را بدانیم
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val bind : ItemsSliderBinding = DataBindingUtil.inflate(LayoutInflater.from(container.context),
            R.layout.items_slider,container,false
        )
        bind.data=list.get(position).image
        container.addView(bind.root)
        return bind.root
    }

    override fun getPageWidth(position: Int): Float {
        return 0.95f // برای اینکه عرض دیفالت 1 است ما میخواهیم کمی کوچکتر باشد تا گوشه عکس بعدی مشخص شود
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}