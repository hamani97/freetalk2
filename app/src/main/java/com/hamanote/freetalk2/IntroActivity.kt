package com.hamanote.freetalk2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.hamanote.freetalk2.base.BaseActivity
import com.hamanote.freetalk2.common.AppGlobal
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        AppGlobal.instance.setContext(this)

        tv_app_version.text = "v" + this.packageManager.getPackageInfo(this.packageName, 0).versionName

        Handler().postDelayed({
            if (AppGlobal.instance.get_user_idx() == "") {
                goToJoin()
            } else {
                goToMain()
            }
        }, 800)
    }

    private fun goToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToJoin() {
        val intent = Intent(this, JoinActivity::class.java)
        startActivity(intent)
        finish()
    }
}