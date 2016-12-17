package com.wakeupngoc.boilerplate.logs;

import android.util.Log;

import timber.log.Timber;

/**
 * Created by ngoctranfire on 12/12/16.
 */

public class LogTree extends Timber.Tree {

    @Override
    protected boolean isLoggable(String tag, int priority) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
            return false;
        }
        return true;
    }

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        if (isLoggable(tag, priority)) {
            if (priority == Log.ASSERT) {
                Log.wtf(tag, message);
            } else {
                Log.println(priority, tag, message);
            }
        }
    }
}
