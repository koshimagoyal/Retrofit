package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://services.intellify.in";

    @GET("api/attendance?for=AllClassAttendance")
    Call<List<Attendance>> getAttendance(@Query("student_id") String id);
}
