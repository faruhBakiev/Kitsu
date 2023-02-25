package com.excample.kitsu.data.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {

    private val preference: SharedPreferences =
        context.getSharedPreferences("userStatus", Context.MODE_PRIVATE)
    operator fun invoke() = preference

}