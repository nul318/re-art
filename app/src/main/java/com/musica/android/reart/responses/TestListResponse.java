package com.musica.android.reart.responses;

import com.google.gson.annotations.SerializedName;
import com.musica.android.reart.entities.TestData;

import java.util.ArrayList;

public class TestListResponse extends SuperResponse {
    @SerializedName("result")
    private ArrayList<TestData> result;
}
