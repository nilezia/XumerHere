package nilezia.project.xumerhere.ui.nearby

import nilezia.project.xumerhere.base.BaseMvpPresenterImp

class NearByPresenter : BaseMvpPresenterImp<NearByContract.View>(), NearByContract.Presenter {


    companion object {

        fun create() = NearByPresenter()

    }


}