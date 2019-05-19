package nilezia.project.xumerhere.ui.save

import nilezia.project.xumerhere.base.BaseMvpPresenterImp

class BookMarkPresenter : BaseMvpPresenterImp<BookMarkContract.View>(), BookMarkContract.Presenter {


    companion object {

        fun create() = BookMarkPresenter()

    }


}