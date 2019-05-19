package nilezia.project.xumerhere.ui.home.child

import android.os.Bundle
import android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.fragment_home_child.*
import nilezia.project.xumerhere.R
import nilezia.project.xumerhere.base.BaseMvpFragment
import nilezia.project.xumerhere.data.Restaurant
import nilezia.project.xumerhere.gone
import nilezia.project.xumerhere.repository.RestaurantRepository
import nilezia.project.xumerhere.toas
import nilezia.project.xumerhere.ui.home.child.adapter.HomeRecyclerAdapter
import nilezia.project.xumerhere.ui.home.child.adapter.PaginationScrollListener
import nilezia.project.xumerhere.ui.me.MyFragment
import nilezia.project.xumerhere.visible
import org.jetbrains.annotations.NotNull
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import nilezia.project.xumerhere.ui.home.child.detail.HomeChildDetailFragment


class HomeChildFragment : BaseMvpFragment<HomeChildContract.View, HomeChildContract.Presenter>(),
    HomeChildContract.View {


    private lateinit var mAdapter: HomeRecyclerAdapter
    private lateinit var mLayoutManager: LinearLayoutManager


    companion object {

        fun newInstance() = HomeChildFragment().apply {

            arguments = Bundle().apply {


            }


        }

    }

    override fun setupLayout(): Int = R.layout.fragment_home_child

    override fun setupView() {


    }

    override fun setupInstance() {
        setupToolbar()
        setupRecyclerView()
        getPresenter().registerRepository(RestaurantRepository())
        getPresenter().loadFirstPage()

        /*fragmentManager?.addOnBackStackChangedListener {
            // Do something

            val count = fragmentManager?.backStackEntryCount
            context?.toas("backStackEntryCount = $count")
        }*/

    }

    private fun setupToolbar() {

        (activity as AppCompatActivity).setSupportActionBar(toolbar as Toolbar?)
    }

    private fun setupRecyclerView() {

        mAdapter = HomeRecyclerAdapter(onItemClickListener())

        mLayoutManager = LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.VERTICAL
            reverseLayout = false
        }

        recyclerView.apply {
            layoutManager = mLayoutManager
            itemAnimator = DefaultItemAnimator()
            adapter = mAdapter
            addOnScrollListener(getPaginationScrollListener())
        }

        mAdapter.notifyDataSetChanged()


    }

    private fun onItemClickListener(): (Restaurant) -> Unit = {

        activity?.toas(it.address!!)
        fragmentManager?.beginTransaction()
            ?.add(R.id.rootContainer, HomeChildDetailFragment.newInstance())
            ?.addToBackStack(null)?.setTransition(TRANSIT_FRAGMENT_FADE)?.commit()
    }

    @NotNull
    private fun getPaginationScrollListener(): PaginationScrollListener {
        return object : PaginationScrollListener(mLayoutManager) {

            override fun loadMoreItems() {

                getPresenter().isLoading = true
                Log.d("LoadMore", "isLoading = ${getPresenter().isLoading} ")


                getPresenter().currentPage += 1
                Log.d("LoadMore", "LoadMore")
                getPresenter().loadNextPage(getPresenter().currentPage)

            }

            override fun getTotalPageCount(): Int = getPresenter().TOTAL_PAGES

            override fun isLastPage(): Boolean = getPresenter().isLastPage

            override fun isLoading(): Boolean = getPresenter().isLoading
        }
    }

    override fun bindView(view: View) {

    }

    override fun createPresenter(): HomeChildContract.Presenter = HomeChildPresenter.create()

    override fun onRestoreInstanceState(bundle: Bundle) {

    }

    override fun updateFirstPage(restaurant: MutableList<Restaurant>) {

        mAdapter.apply {

            addAll(restaurant)

        }.run {
            if (getPresenter().currentPage <= getPresenter().TOTAL_PAGES) addLoadingFooter()
            else getPresenter().isLastPage = true
            notifyDataSetChanged()
        }


    }

    override fun updateNextPage(restaurant: MutableList<Restaurant>) {

        mAdapter.apply {

            removeLoadingFooter()
            getPresenter().isLoading = false
            Log.d("LoadMore", "isLoading = ${getPresenter().isLoading} ")
            addAll(restaurant)

        }.run {

            if (getPresenter().currentPage != getPresenter().TOTAL_PAGES) addLoadingFooter()
            else getPresenter().isLastPage = true

        }
    }

    override fun showProgressBar() = progressLoading.visible()

    override fun hideProgressBar() = progressLoading.gone()


}