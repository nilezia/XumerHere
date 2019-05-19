package nilezia.project.xumerhere.ui.home.child

import android.util.Log
import nilezia.project.xumerhere.base.BaseMvpPresenterImp
import nilezia.project.xumerhere.model.ResponseModel
import nilezia.project.xumerhere.model.RestaurantListener
import nilezia.project.xumerhere.repository.RestaurantRepository

class HomeChildPresenter : BaseMvpPresenterImp<HomeChildContract.View>(), HomeChildContract.Presenter {

    override var PAGE_START: Int = 0


    override var isLoading: Boolean = false


    override var isLastPage: Boolean = false


    override var TOTAL_PAGES: Int = 0

    override var currentPage: Int = PAGE_START

    private lateinit var mRepository: RestaurantRepository


    companion object {

        fun create() = HomeChildPresenter()

    }

    override fun registerRepository(repository: RestaurantRepository) {
        this.mRepository = repository

    }


    override fun loadFirstPage() {


        getRepository().getFirstPage("US", object : RestaurantListener {
            override fun onResponseSuccess(result: ResponseModel) {

                TOTAL_PAGES = (result.total_entries/result.per_page).toInt()
                getView().hideProgressBar()
                getView().updateFirstPage(result.restaurants)
                Log.d("Response", "${result.per_page}")
            }

            override fun onResponseError(error: String) {
                Log.d("Response", error)
            }
        })

    }

    override fun loadNextPage(currentPage: Int) {

        Log.d("Response", "currentPage =  $currentPage")

        getRepository().getNextPage("US", currentPage, object : RestaurantListener {
            override fun onResponseSuccess(result: ResponseModel) {
                getView().hideProgressBar()
                getView().updateNextPage(result.restaurants)
                Log.d("Response", result.restaurants.toString())
            }

            override fun onResponseError(error: String) {
                Log.d("Response", error)
            }
        })

    }

    private fun getRepository(): RestaurantRepository = mRepository

}