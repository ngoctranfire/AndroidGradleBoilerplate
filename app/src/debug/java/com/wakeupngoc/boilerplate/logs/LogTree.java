package com.wakeupngoc.boilerplate.logs;

import timber.log.Timber;

/**
 * Created by ngoctranfire on 12/12/16.
 */

public class LogTree extends Timber.DebugTree {
    @Override
    protected String createStackElementTag(StackTraceElement element) {
        return "*HatchGoalsLog*" + " (" + super.createStackElementTag(element) + ".java:" + element.getLineNumber() + ")";
    }
}
