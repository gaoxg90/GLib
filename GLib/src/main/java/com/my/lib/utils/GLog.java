package com.my.lib.utils;

import com.my.lib.g;

import com.orhanobut.logger.Logger;

public class GLog {

    public static void d(String tag, Object msg) {
        if (g.isDebug()) {
            Logger.init(tag);
            Logger.d(msg);
        }
    }

    public static void e(Object msg) {
        if (g.isDebug()) {
            Logger.init("err");
            Logger.d(msg);
        }
    }

    public static void e(String tag, Object msg) {
        if (g.isDebug()) {
            Logger.init(tag);
            Logger.d(msg);
        }
    }
}
