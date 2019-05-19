package nilezia.project.xumerhere.ui.pager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter


class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()



    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    /**
     * If you want to only show icons, return null from this method.
     * @param position
     * @return
     */
    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

}


