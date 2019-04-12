package com.elveselimoski.starterapp.json;

import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

public final class GsonUtil {

    @VisibleForTesting
    private static GsonBuilder defaultGsonBuilder = new GsonBuilder()
            .registerTypeHierarchyAdapter(Uri.class, new UriTypeAdapter().nullSafe())
            .registerTypeHierarchyAdapter(Date.class, new DateTypeAdapter().nullSafe());
    public static Gson defaultGson = defaultGsonBuilder.create();

    private GsonUtil() {
    }
}
