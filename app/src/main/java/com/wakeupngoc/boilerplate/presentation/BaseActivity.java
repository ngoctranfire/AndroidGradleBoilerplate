package com.wakeupngoc.boilerplate.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import timber.log.Timber;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract void injectComponent();

    @Override
    protected void onCreate(@Nullable Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        Timber.i("onCreate() -> [%s]", getClassName());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Timber.i("onActivityResult() -> [%s]", this.getClassName());
    }

    private String getClassName() {
        return this.getLocalClassName();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Timber.i("onStart() -> []%s", getClassName());
    }

    @Override
    protected void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Timber.i("onRestoreInstanceState() -> [%s]", getClassName());
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Timber.i("onPostCreate() -> [%s]", getClassName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.i("onResume() -> [%s]", getClassName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Timber.i("onPause() -> [%s]", getClassName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Timber.i("onStop() -> [%s]", getClassName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Timber.i("onRestart() -> [%s]", getClassName());
    }

    @Override
    protected void onSaveInstanceState(@Nullable Bundle outState) {
        super.onSaveInstanceState(outState);
        Timber.i("onSaveInstanceState -> [%s]", getClassName());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.i("onDestroy() -> [%s]", getClassName());
    }
}
