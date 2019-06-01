package com.musica.android.reart.responses;

import com.google.gson.annotations.SerializedName;
import com.musica.android.reart.entities.TestData;

public class TestDetailResponse extends SuperResponse {
    @SerializedName("result")
    private TestData result;
}
