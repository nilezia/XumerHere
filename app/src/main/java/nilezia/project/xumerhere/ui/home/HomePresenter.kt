package nilezia.project.xumerhere.ui.home

import nilezia.project.xumerhere.base.BaseMvpPresenterImp


class HomePresenter : BaseMvpPresenterImp<HomeContract.View>(), HomeContract.Presenter {


    companion object {

        fun create() = HomePresenter()

    }




}