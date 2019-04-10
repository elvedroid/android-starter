package com.elveselimoski.starterapp.json

import android.net.Uri
import androidx.annotation.VisibleForTesting
import com.google.gson.Gson
import com.google.gson.GsonBuilder

import java.util.Date

object GsonUtil {

    @get:VisibleForTesting
    val defaultGsonBuilder: GsonBuilder = GsonBuilder()
        .registerTypeHierarchyAdapter(Uri::class.java, UriTypeAdapter().nullSafe())
        .registerTypeHierarchyAdapter(Date::class.java, DateTypeAdapter().nullSafe())

    val defaultGson: Gson = defaultGsonBuilder.create()
}
