package nilezia.project.xumerhere.ui.home.child

import nilezia.project.xumerhere.base.BaseMvpPresenter
import nilezia.project.xumerhere.base.BaseMvpView
import nilezia.project.xumerhere.data.Restaurant
import nilezia.project.xumerhere.repository.RestaurantRepository

interface HomeChildContract {


    interface View : BaseMvpView {

        fun updateFirstPage(restaurant: MutableList<Restaurant>)

        fun updateNextPage(restaurant: MutableList<Restaurant>)

        fun showProgressBar()

        fun hideProgressBar()
    }


    interface Presenter : BaseMvpPresenter<View> {

        var PAGE_START: Int
        var isLoading: Boolean
        var isLastPage: Boolean
        var TOTAL_PAGES: Int
        var currentPage: Int

        fun registerRepository(repository: RestaurantRepository)

        fun loadFirstPage()

        fun loadNextPage(currentPage: Int)
    }
}