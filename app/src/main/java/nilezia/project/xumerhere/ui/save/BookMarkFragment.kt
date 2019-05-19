package nilezia.project.xumerhere.ui.save

import android.os.Bundle
import android.view.View
import nilezia.project.xumerhere.R
import nilezia.project.xumerhere.base.BaseMvpFragment

class BookMarkFragment : BaseMvpFragment<BookMarkContract.View, BookMarkContract.Presenter>(), BookMarkContract.View {


    companion object {

        fun newInstance() = BookMarkFragment().apply {

            arguments = Bundle().apply {


            }


        }
    }


    override fun setupLayout(): Int = R.layout.fragment_book_mark

    override fun setupView() {
        
    }

    override fun setupInstance() {
        
    }

    override fun bindView(view: View) {
        
    }

    override fun createPresenter(): BookMarkContract.Presenter = BookMarkPresenter.create()

    override fun onRestoreInstanceState(bundle: Bundle) {
        
    }


}