package nilezia.project.xumerhere.ui.home

import android.os.Bundle
import android.view.View
import nilezia.project.xumerhere.R
import nilezia.project.xumerhere.base.BaseMvpFragment
import nilezia.project.xumerhere.ui.home.child.HomeChildFragment


class HomeFragment : BaseMvpFragment<HomeContract.View, HomeContract.Presenter>(), HomeContract.View {


    companion object {

        fun newInstance() = HomeFragment().apply {

            arguments = Bundle().apply {


            }


        }


    }


    override fun setupLayout(): Int = R.layout.fragment_home


    override fun setupView() {

    }

    override fun setupInstance() {
        childFragmentManager.beginTransaction()
            .add(R.id.rootContainer, HomeChildFragment.newInstance(), "HomeChildFragment").addToBackStack(null).commit()


    }

    override fun bindView(view: View) {

    }

    override fun createPresenter(): HomeContract.Presenter = HomePresenter.create()

    override fun onRestoreInstanceState(bundle: Bundle) {



    }



}