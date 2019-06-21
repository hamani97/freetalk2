package com.hamanote.freetalk2

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.MenuItem
import com.hamanote.freetalk.fragment.FavoriteFragment
import com.hamanote.freetalk.fragment.HomeFragment
import com.hamanote.freetalk.fragment.TalkFragment
import com.hamanote.freetalk2.base.BaseActivity
import com.hamanote.freetalk2.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
//    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        val appName = this.packageManager.getPackageInfo(this.packageName, 0).versionName
        adapter.addFragment(HomeFragment(), appName)
        adapter.addFragment(FavoriteFragment(), "Friend")
        adapter.addFragment(TalkFragment(), "Talk")

        container.adapter = adapter
        adapter.notifyDataSetChanged()

        // Bind tab menu
        tabs.setupWithViewPager(container)

        tabs.getTabAt(0)?.setIcon(R.drawable.ic_home_black_24dp)
        tabs.getTabAt(1)?.setIcon(R.drawable.ic_people_black_24dp)
        tabs.getTabAt(2)?.setIcon(R.drawable.ic_chat_black_24dp)

        tabs.getTabAt(0)?.setText("Home")
        tabs.getTabAt(1)?.setText("Favorite")
        tabs.getTabAt(2)?.setText("Room")

        tabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onTabSelected(tab: TabLayout.Tab?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        container.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(state: Int) {
                (adapter.getItem(state) as BaseFragment).onSelected()
            }
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageScrollStateChanged(position: Int) {}
        })

        btn_write.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    private class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        private val mFragments = ArrayList<Fragment>()
        private val mFragmentTitles = ArrayList<String>()

        fun addFragment(fragment: Fragment, title: String) {
            mFragments.add(fragment)
            mFragmentTitles.add(title)
        }
        override fun getItem(position: Int): Fragment {
            return mFragments.get(position)
        }
        override fun getCount(): Int {
            return mFragments.size
        }
        override fun getItemPosition(`object`: Any?): Int {
            return PagerAdapter.POSITION_NONE
        }
        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitles.get(position)
        }
    }
}
