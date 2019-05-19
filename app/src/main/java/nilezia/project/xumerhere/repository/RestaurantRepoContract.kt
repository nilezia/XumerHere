package nilezia.project.xumerhere.repository

import nilezia.project.xumerhere.model.RestaurantListener

interface RestaurantRepoContract {

    fun getFirstPage(country: String, listener: RestaurantListener)

    fun getNextPage(country: String, page: Int, listener: RestaurantListener)
}