package nilezia.project.xumerhere.ui.home.child.detail

import nilezia.project.xumerhere.base.BaseMvpPresenterImp

class HomeChildDetailPresenter : BaseMvpPresenterImp<HomeChildDetailContract.View>(),
    HomeChildDetailContract.Presenter {

    companion object {

        fun create() = HomeChildDetailPresenter()

    }

}