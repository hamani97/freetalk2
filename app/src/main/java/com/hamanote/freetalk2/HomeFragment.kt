package com.hamanote.freetalk.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hamanote.freetalk2.MainActivity
import com.hamanote.freetalk2.R
import com.hamanote.freetalk2.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*

class HomeFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onSelected() {
//        activity.setTitle(R.string.app_name)
        (activity as MainActivity).toolbar.title = "BBB"
    }
    override fun initViews() {
        (activity as MainActivity).toolbar.title = "BBB"
    }
}