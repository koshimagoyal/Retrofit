package com.example.retrofit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AttendanceAdapter adapter;
    RecyclerView recyclerView;
    EditText editText;
    Button get_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        get_btn = findViewById(R.id.get_btn);


        get_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText = findViewById(R.id.student_id);
                recyclerView = findViewById(R.id.recyclerview);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                AttendanceViewModel model = ViewModelProviders.of(MainActivity.this).get(AttendanceViewModel.class);
                model.getAttendance(editText.getText().toString()).observe(MainActivity.this, new Observer<List<Attendance>>() {
                    @Override
                    public void onChanged(@Nullable List<Attendance> attendanceList) {
                        adapter = new AttendanceAdapter(MainActivity.this, attendanceList);
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        });


    }
}
