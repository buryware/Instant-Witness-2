package com.buryware.firebase.instantwitness;

import android.app.Application;
import android.support.annotation.Nullable;

import io.firekast.Firekast;

public class App extends Application {

    @Nullable
    public static String latestStreamId = null;

    @Override
    public void onCreate() {
        super.onCreate();
        Firekast.initialize(this, "$2a$10$G.AC41XjDgCdOBoaESYzW.ttx0p3uzyZ3NcJPznrWbppBaXvewJZO");
    }
}
