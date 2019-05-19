package nilezia.project.xumerhere.data

data class Restaurant(
    val address: String? = null,
    val area: String? = null,
    val city: String? = null,
    val country: String? = null,
    val id: Int,
    val image_url: String? = null,
    val lat: Double,
    val lng: Double,
    val mobile_reserve_url: String? = null,
    val name: String? = null,
    val phone: String? = null,
    val postal_code: String? = null,
    val price: Int,
    val reserve_url: String? = null,
    val state: String? = null
) {

    constructor() : this(
        "", "", "", "", -1, "", 0.0, 0.0,
        "", "", "", "", 0, "", ""
    )

}