package nilezia.project.xumerhere.ui.home.child.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import android.util.Log


abstract class PaginationScrollListener(var layoutManager: LinearLayoutManager) :
    RecyclerView.OnScrollListener() {


    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        if (!isLoading() && !isLastPage()) {
            Log.d("LoadMore", "$visibleItemCount  $firstVisibleItemPosition $totalItemCount")
            if ((visibleItemCount + firstVisibleItemPosition )>= totalItemCount && firstVisibleItemPosition >= 0) {
                loadMoreItems()
            }
        }
    }

    protected abstract fun loadMoreItems()

    abstract fun getTotalPageCount(): Int

    abstract fun isLastPage(): Boolean

    abstract fun isLoading(): Boolean

}