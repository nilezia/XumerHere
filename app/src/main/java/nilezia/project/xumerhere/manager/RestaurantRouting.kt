package nilezia.project.xumerhere.manager

import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.util.FuelRouting

sealed class RestaurantRouting : FuelRouting {


    override val basePath: String
        get() = "http://opentable.herokuapp.com/api"

    class getRestaurant(val country: String) : RestaurantRouting() {
        override val method: Method
            get() = Method.GET

        override val path: String
            get() = "/restaurants"

        override val params: List<Pair<String, Any?>>?
            get() = listOf("country" to country)

        override val headers: Map<String, String>?
            get() = null
    }

}