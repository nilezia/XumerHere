package nilezia.project.xumerhere.ui

import nilezia.project.xumerhere.base.BaseMvpPresenterImp

class MainActivityPresenter : BaseMvpPresenterImp<MainActivityContract.View>(), MainActivityContract.Presenter {


    companion object {

        fun create(): MainActivityContract.Presenter = MainActivityPresenter()


    }


}