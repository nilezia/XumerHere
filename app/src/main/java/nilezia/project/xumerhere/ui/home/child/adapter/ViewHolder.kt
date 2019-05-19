package nilezia.project.xumerhere.ui.home.child.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_item_default.view.*
import nilezia.project.xumerhere.data.Restaurant


class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    @SuppressLint("SetTextI18n")
    fun bindView( itemclickListener:(Restaurant)->Unit,restaurant: Restaurant) = with(itemView) {

        tvName.text = restaurant.name
        tvAddress.text = restaurant.address
        tvCity.text = restaurant.city
        Glide.with(this).load(restaurant.image_url).into(imgRestaurant)

        setOnClickListener{

            itemclickListener.invoke(restaurant)

        }

    }
}