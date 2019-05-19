package nilezia.project.xumerhere.repository

import com.github.kittinunf.fuel.Fuel
import nilezia.project.xumerhere.manager.RestaurantRouting
import nilezia.project.xumerhere.model.ResponseModel
import nilezia.project.xumerhere.model.RestaurantListener

class RestaurantRepository : RestaurantRepoContract {


    override fun getFirstPage(country: String, listener: RestaurantListener) {


        Fuel.request(RestaurantRouting.getRestaurant(country))
            .responseObject(ResponseModel.Deserializer()) { _, _, result ->
                result.fold(success = { userProfile ->
                    listener.onResponseSuccess(userProfile)
                }, failure = { error ->
                    listener.onResponseError(error.toString())
                })

            }

    }

    override fun getNextPage(country: String, page: Int, listener: RestaurantListener) {

        Fuel.get("http://opentable.herokuapp.com/api/restaurants", listOf("country" to country, "page" to page))
            .responseObject(ResponseModel.Deserializer()) { _, _, result ->
                result.fold(success = { userProfile ->
                    listener.onResponseSuccess(userProfile)
                }, failure = { error ->
                    listener.onResponseError(error.toString())
                })

            }

    }

}