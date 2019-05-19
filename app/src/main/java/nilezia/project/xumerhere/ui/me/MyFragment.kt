package nilezia.project.xumerhere.ui.me

import android.os.Bundle
import android.view.View
import nilezia.project.xumerhere.R
import nilezia.project.xumerhere.base.BaseMvpFragment

class MyFragment : BaseMvpFragment<MeContract.View, MeContract.Presenter>(), MeContract.View {


    companion object {

        fun newInstance() = MyFragment().apply {

            arguments = Bundle().apply {


            }


        }
    }

    override fun setupLayout(): Int = R.layout.fragment_my

    override fun setupView() {

    }

    override fun setupInstance() {

    }

    override fun bindView(view: View) {

    }

    override fun createPresenter(): MeContract.Presenter = MyPresenter.create()

    override fun onRestoreInstanceState(bundle: Bundle) {

    }


}