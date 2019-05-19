package nilezia.project.xumerhere.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import nilezia.project.xumerhere.R
import nilezia.project.xumerhere.base.BaseMvpActivity
import nilezia.project.xumerhere.ui.home.HomeFragment
import nilezia.project.xumerhere.ui.me.MyFragment
import nilezia.project.xumerhere.ui.nearby.NearByFragment
import nilezia.project.xumerhere.ui.pager.ViewPagerAdapter
import nilezia.project.xumerhere.ui.save.BookMarkFragment


class MainActivity : BaseMvpActivity<MainActivityContract.View, MainActivityContract.Presenter>(),
    MainActivityContract.View {

    private lateinit var adapter: ViewPagerAdapter
    private var prevMenuItem: MenuItem? = null
    private val HOME_ITEM = 0
    private val NEAR_BY_ITEM = 1
    private val BOOK_MARK_ITEM = 2
    private val MY_ITEM = 3

    override fun initial() {

        setupViewPager()

    }

    private fun setupViewPager() {


        adapter = ViewPagerAdapter(supportFragmentManager).apply {

            addFragment(HomeFragment.newInstance(), "Home")
            addFragment(NearByFragment.newInstance(), "Near")
            addFragment(BookMarkFragment.newInstance(), "Save")
            addFragment(MyFragment.newInstance(), "Me")

        }
        viewPager.adapter = adapter
        viewPager.setPagingEnabled(false)
        viewPager.offscreenPageLimit = 4
        bottomNavView.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.item_home -> {
                    viewPager.setCurrentItem(HOME_ITEM, false)

                }
                R.id.item_near_by -> {
                    viewPager.setCurrentItem(NEAR_BY_ITEM, false)
                }

                R.id.item_book_mark -> {
                    viewPager.setCurrentItem(BOOK_MARK_ITEM, false)

                }

                R.id.item_person -> {
                    viewPager.setCurrentItem(MY_ITEM, false)

                }

            }

            false

        }
        viewPager.addOnPageChangeListener(pageChangeListener)
        viewPager.setOnTouchListener { _, _ -> true }
    }


    override fun setupLayout(): Int = R.layout.activity_main

    override fun setupView() {

    }

    override fun setupInstance() {

    }

    override fun createPresenter(): MainActivityContract.Presenter = MainActivityPresenter.create()

    override fun onRestoreInstanceState(bundle: Bundle) {

    }

    private var pageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(p0: Int) {

        }

        override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

        }

        override fun onPageSelected(p0: Int) {
            if (prevMenuItem != null) {
                prevMenuItem!!.isChecked = false
            } else {
                bottomNavView.menu.getItem(HOME_ITEM).isChecked = false
            }
            Log.d("page", "onPageSelected: $p0")
            bottomNavView.menu.getItem(p0).isChecked = true
            prevMenuItem = bottomNavView.menu.getItem(p0)

        }
    }

    override fun onBackPressed() {

        val isFragmentPopped = handleViewPagerBackStack()
        if (!isFragmentPopped) {
            super.onBackPressed()
        }


    }

    private fun handleViewPagerBackStack(): Boolean {
        val fragment: Fragment? = getCurrentFragment(supportFragmentManager, viewPager)
        return fragment?.let {
            handleNestedFragmentBackStack(fragment.childFragmentManager)
        } ?: run {
            false
        }
    }

    private fun getCurrentFragment(fragmentManager: FragmentManager, viewPager: ViewPager): Fragment? {
        val fragmentList = fragmentManager.fragments
        val currentSize = fragmentList.size
        val maxSize = viewPager.adapter?.count ?: 0
        val lastPosition = if (maxSize > 0) maxSize - 1 else 0
        val position = viewPager.currentItem
        val offset = viewPager.offscreenPageLimit
        return when {
            maxSize == 0 -> null
            position <= offset -> fragmentList[position]
            position == lastPosition -> fragmentList[currentSize - 1]
            position > lastPosition - offset -> fragmentList[maxSize - offset]
            currentSize < maxSize -> fragmentList[offset]
            currentSize >= maxSize -> fragmentList[position]
            else -> null
        }
    }

    private fun handleNestedFragmentBackStack(fragmentManager: FragmentManager): Boolean {
        val childFragmentList = fragmentManager.fragments
        if (childFragmentList.size > 0) {
            for (index in childFragmentList.size - 1 downTo 0) {
                val fragment = childFragmentList[index]
                val isPopped = handleNestedFragmentBackStack(fragment.childFragmentManager)
                return when {
                    isPopped -> true
                    fragmentManager.backStackEntryCount > 1 -> {
                        fragmentManager.popBackStack()
                        true
                    }
                    else -> false
                }
            }
        }
        return false
    }
}
