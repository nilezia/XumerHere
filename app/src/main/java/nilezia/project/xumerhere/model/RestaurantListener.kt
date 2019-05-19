package nilezia.project.xumerhere.model

interface RestaurantListener {

    fun onResponseSuccess(result: ResponseModel)

    fun onResponseError(error: String)


}