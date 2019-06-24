package com.hamanote.freetalk2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.hamanote.freetalk2.base.BaseActivity
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        tv_app_version.text = "v" + this.packageManager.getPackageInfo(this.packageName, 0).versionName

        Handler().postDelayed({
            moveToNext()
        }, 800)
    }

    private fun moveToNext() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}