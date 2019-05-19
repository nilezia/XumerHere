package nilezia.project.xumerhere.ui.home.child.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.fragment_home_child.*
import nilezia.project.xumerhere.R
import nilezia.project.xumerhere.base.BaseMvpFragment

class HomeChildDetailFragment : BaseMvpFragment<HomeChildDetailContract.View, HomeChildDetailContract.Presenter>(),
    HomeChildDetailContract.View {


    companion object {

        fun newInstance() = HomeChildDetailFragment().apply {

            arguments = Bundle().apply {


            }


        }

    }

    private fun setupToolbar() {

        (activity as AppCompatActivity).setSupportActionBar(toolbar as Toolbar?)
        (activity as AppCompatActivity).supportActionBar?.apply {

            title = ""
            setDisplayHomeAsUpEnabled(true)


        }
    }

    override fun setupLayout(): Int = R.layout.fragment_home_child_detail

    override fun setupView() {
        setHasOptionsMenu(true)
    }

    override fun setupInstance() {

        setupToolbar()


    }

    override fun bindView(view: View) {

    }

    override fun createPresenter(): HomeChildDetailContract.Presenter = HomeChildDetailPresenter.create()

    override fun onRestoreInstanceState(bundle: Bundle) {

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == android.R.id.home) {

            fragmentManager?.popBackStack()

        }
        return super.onOptionsItemSelected(item)
    }


}