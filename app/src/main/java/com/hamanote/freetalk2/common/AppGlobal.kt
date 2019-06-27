package com.hamanote.freetalk2.common

import android.content.Context

class AppGlobal private constructor() {

    private var context : Context? = null

    private object Holder { val INSTANCE = AppGlobal() }

    companion object {
        val instance: AppGlobal by lazy { Holder.INSTANCE }
    }
    fun setContext(ctx : Context) { context = ctx }

    // Default settings
    fun set_user_idx(idx: String) { LocalStorage.setString(instance.context!!, "user_idx", idx) }
    fun get_user_idx() : String { return LocalStorage.getString(instance.context!!, "user_idx") }
    fun set_user_id(userid: String) { LocalStorage.setString(instance.context!!, "user_id", userid) }
    fun get_user_id() : String { return LocalStorage.getString(instance.context!!, "user_id") }
}