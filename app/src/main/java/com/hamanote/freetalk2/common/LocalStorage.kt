package com.hamanote.freetalk2.common

import android.content.Context

object LocalStorage {

    private val APP_KEY = "app"

    fun setString(ctx: Context, key: String, data: String) {
        val editor = ctx.getSharedPreferences(APP_KEY, Context.MODE_PRIVATE).edit()
        editor.putString(key, data)
        editor.commit()
    }
    fun getString(ctx: Context, key: String): String {
        var data = ctx.getSharedPreferences(APP_KEY, Context.MODE_PRIVATE).getString(key, "")
        if (data == null) data = ""
        return data
    }
}