package com.hamanote.freetalk2

import android.os.Bundle
import android.support.design.widget.Snackbar
import com.hamanote.freetalk2.base.BaseActivity
import kotlinx.android.synthetic.main.activity_join.*

class JoinActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

//        setSupportActionBar(my_toolbar)

//        supportActionBar.setIcon(R.drawable.ic_chevron_left_darkgray_48dp)
//        ActionBar ab = this.supportActionBar
//        supportActionBar.icon(R.id.)
//        supportParentActivityIntent
//        setTitle("회원가입")

        val appName = this.packageManager.getPackageInfo(this.packageName, 0).versionName

        // Bind button
        tv_btn_join.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}
