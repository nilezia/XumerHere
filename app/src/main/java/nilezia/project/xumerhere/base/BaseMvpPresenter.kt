package nilezia.project.xumerhere.base

interface BaseMvpPresenter<V : BaseMvpView> {

    fun attachView(view: V)

    fun detachView()

    fun getView():V

}