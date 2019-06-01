package com.musica.android.reart.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.Gson;

import io.reactivex.disposables.CompositeDisposable;

public abstract class SuperActivity extends AppCompatActivity {

    Gson mGson = new Gson();
    CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    ProgressDialog pd;

    public abstract void onClick(View v);
    abstract void initViews();

    public void showProgressDialog() {
        if(pd == null)
            pd = new ProgressDialog(this);
//        progressDialog.setMessage(getString(R.string.loading_buy_point));
        pd.setMessage("Loading");
        pd.setCancelable(false);
        pd.show();
    }


    public void dismissProgressDialog() {
        if(pd != null) pd.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
    }



}
