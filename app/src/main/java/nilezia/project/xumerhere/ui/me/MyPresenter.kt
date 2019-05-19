package nilezia.project.xumerhere.ui.me

import nilezia.project.xumerhere.base.BaseMvpPresenterImp

class MyPresenter : BaseMvpPresenterImp<MeContract.View>(), MeContract.Presenter {


    companion object {

        fun create() = MyPresenter()

    }


}