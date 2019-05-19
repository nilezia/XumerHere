package nilezia.project.xumerhere.ui.home.child.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import nilezia.project.xumerhere.R
import nilezia.project.xumerhere.data.Restaurant


class HomeRecyclerAdapter(var itemClickListener:(Restaurant)->Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val ITEM = 0
    private val LOADING = 1
    private var isLoadingAdded: Boolean = false
    private var restaurants: MutableList<Restaurant> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var viewHolder: RecyclerView.ViewHolder? = null
        when (viewType) {
            ITEM -> {

                val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_default, parent, false)
                viewHolder = ViewHolder(view)
            }


            LOADING -> {

                val view = LayoutInflater.from(parent.context).inflate(R.layout.view_progress_loadmore, parent, false)
                viewHolder = ProgressViewHolder(view)

            }
        }

        return viewHolder!!
    }

    override fun getItemCount(): Int = restaurants.size


    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        val restaurant = restaurants.get(position)

        when (getItemViewType(position)) {
            ITEM -> {
                val item = viewHolder as ViewHolder
                item.bindView(itemClickListener,restaurant)
            }
            LOADING -> {


            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (position == restaurants.size - 1 && isLoadingAdded) LOADING else ITEM
    }

    private fun add(mc: Restaurant) {
        restaurants.add(mc)
        notifyItemInserted(restaurants.size - 1)
    }

    fun addAll(restaurants: MutableList<Restaurant>) {
        for (restaurant in restaurants) {
            add(restaurant)
        }
    }

    private fun remove(city: Restaurant?) {
        val position = restaurants.indexOf(city)
        if (position > -1) {
            restaurants.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun clear() {
        isLoadingAdded = false
        while (itemCount > 0) {
            remove(getItem(0))
        }
    }

    fun isEmpty(): Boolean {
        return itemCount == 0
    }

    fun addLoadingFooter() {
        isLoadingAdded = true
        add(Restaurant())
    }

    fun removeLoadingFooter() {
        isLoadingAdded = false

        val position = restaurants.size - 1
        val item = getItem(position)
        if (item != null) {
            restaurants.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    private fun getItem(position: Int): Restaurant? {
        return restaurants[position]
    }

    interface OnClikItemListener{

        fun setOnclickItemListener():(Restaurant)->Unit

    }
}