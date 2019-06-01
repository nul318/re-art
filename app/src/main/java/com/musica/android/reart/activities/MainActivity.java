package com.musica.android.reart.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.musica.android.reart.ReartApp;
import com.musica.android.reart.R;
import com.musica.android.reart.responses.SuperResponse;
import com.musica.android.reart.responses.TestDetailResponse;
import com.musica.android.reart.responses.TestListResponse;
import com.musica.android.reart.utils.Utils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

import static com.musica.android.reart.ReartApp.MEDIA_TYPE_JSON;
import static com.musica.android.reart.ReartApp.catchAllThrowable;

public class MainActivity extends SuperActivity {

    //    Views Naming Rule
    TextView tvResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_test:
                firstTest();
                break;
            case R.id.second_test:
                secondTest(1);
                break;
            case R.id.third_test:
                thirdTest(Utils.getNowByTimeStamp());
                break;
        }
    }

    @Override
    void initViews() {
        tvResponse = findViewById(R.id.response);
    }

    void firstTest() {

        ReartApp.getRetrofitMethod(getApplicationContext()).getTestDataList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TestListResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                        showProgressDialog();
                    }

                    @Override
                    public void onNext(TestListResponse res) {
                        if (res.isSuccess()) {
                            tvResponse.setText(mGson.toJson(res));
                        }
                        //에러 처리 시작

                        //에러 처리 끝

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getApplicationContext(), catchAllThrowable(getApplicationContext(), e), Toast.LENGTH_SHORT).show();

                        dismissProgressDialog();
                    }

                    @Override
                    public void onComplete() {
                        dismissProgressDialog();
                    }
                });
    }


    void secondTest(int testNo) {

        ReartApp.getRetrofitMethod(getApplicationContext()).getTestData(testNo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TestDetailResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                        showProgressDialog();
                    }

                    @Override
                    public void onNext(TestDetailResponse res) {
                        if (res.isSuccess()) {
                            tvResponse.setText(mGson.toJson(res));
                        }
                        //에러 처리 시작

                        //에러 처리 끝

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getApplicationContext(), catchAllThrowable(getApplicationContext(), e), Toast.LENGTH_SHORT).show();

                        dismissProgressDialog();
                    }

                    @Override
                    public void onComplete() {
                        dismissProgressDialog();
                    }
                });
    }


    void thirdTest(String name) {

        JsonObject params = new JsonObject();
        params.addProperty("name", name);

        ReartApp.getRetrofitMethod(getApplicationContext()).postTestData(RequestBody.create(MEDIA_TYPE_JSON, params.toString()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SuperResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                        showProgressDialog();
                    }

                    @Override
                    public void onNext(SuperResponse res) {
                        if (res.isSuccess()) {
                            tvResponse.setText(mGson.toJson(res));
                        }
                        //에러 처리 시작

                        //에러 처리 끝

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getApplicationContext(), catchAllThrowable(getApplicationContext(), e), Toast.LENGTH_SHORT).show();

                        dismissProgressDialog();
                    }

                    @Override
                    public void onComplete() {
                        dismissProgressDialog();
                    }
                });
    }


}
