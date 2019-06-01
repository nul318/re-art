package com.musica.android.reart;


import com.musica.android.reart.responses.SuperResponse;
import com.musica.android.reart.responses.TestDetailResponse;
import com.musica.android.reart.responses.TestListResponse;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Retrofit에서 사용하는 통신 인터페이스
 */
public interface RetrofitInterface {


    //GET API Example
    @GET("test")
    Observable<TestListResponse> getTestDataList();

    //GET API Path Variable Example
    @GET("test/{testNo}")
    Observable<TestDetailResponse> getTestData(@Path("testNo") int testNo);

    //POST API Body Data Example
    @POST("test")
    Observable<SuperResponse> postTestData(@Body RequestBody params);

//    Mixed Example
//    @POST("test/{v1}/{v2}")
//    Observable<SuperResponse> postTestData(@Path("v1") String v1,
//                                                 @Path("v2") String v2,
//                                                 @Body RequestBody params);

}
