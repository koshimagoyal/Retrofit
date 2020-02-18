package com.example.retrofit;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AttendanceViewModel extends ViewModel {

    private MutableLiveData<List<Attendance>> attendanceList;

    public LiveData<List<Attendance>> getAttendance(String student_id) {

        if (attendanceList == null){
            attendanceList = new MutableLiveData<>();

            loadAttendance(student_id);
        }

        return attendanceList;
    }

    private void loadAttendance(String student_id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofit.create(Api.class);
        Call<List<Attendance>> call = api.getAttendance(student_id);

        call.enqueue(new Callback<List<Attendance>>() {
            @Override
            public void onResponse(Call<List<Attendance>> call, Response<List<Attendance>> response) {

                if(response.code()==404){
                    JSONObject jsonObject;
                    try{
                        jsonObject = new JSONObject(response.errorBody().string());
                        String errorMessage = jsonObject.getString("userMessage");
                        String errorCode = jsonObject.getString("errorCode");
                        String error = errorMessage+errorCode;
                        Log.v("Error",error);

                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }else {
                    attendanceList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Attendance>> call, Throwable t) {

                Log.v("Error",t.getMessage());

            }
        });
    }

}
