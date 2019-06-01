package com.musica.android.reart;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.musica.android.reart.ReartApp.TAG;
import static com.musica.android.reart.ReartApp.X_ACCESS_TOKEN;


public class XAccessTokenInterceptor implements Interceptor {

    private SharedPreferences mSharedPreferences;

    XAccessTokenInterceptor(Context context) {
        mSharedPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);

    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        String jwtToken = mSharedPreferences.getString(X_ACCESS_TOKEN, null);
        if (jwtToken != null) {
            builder.addHeader("x-access-token", jwtToken);
        }
        return chain.proceed(builder.build());
    }
}
