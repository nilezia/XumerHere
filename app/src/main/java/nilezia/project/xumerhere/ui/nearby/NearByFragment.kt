package nilezia.project.xumerhere.ui.nearby

import android.os.Bundle
import android.view.View
import nilezia.project.xumerhere.R
import nilezia.project.xumerhere.base.BaseMvpFragment

class NearByFragment : BaseMvpFragment<NearByContract.View, NearByContract.Presenter>(), NearByContract.View{

    companion object {

        fun newInstance() = NearByFragment().apply {

            arguments = Bundle().apply {


            }


        }
    }
    override fun setupLayout(): Int = R.layout.fragment_near_by

    override fun setupView() {
        
    }

    override fun setupInstance() {
        
    }

    override fun bindView(view: View) {
        
    }

    override fun createPresenter(): NearByContract.Presenter = NearByPresenter.create()

    override fun onRestoreInstanceState(bundle: Bundle) {
        
    }


}