package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder> {

    private Context ctx;
    private List<Attendance> attendanceList;

    public AttendanceAdapter(Context ctx,List<Attendance> attendanceList){
        this.ctx = ctx;
        this.attendanceList = attendanceList;
    }

    @Override
    public AttendanceViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.recyclerview_layout,null);
        return new AttendanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AttendanceViewHolder holder, int position){
        Attendance attendance = attendanceList.get(position);

        //binding of data
        holder.tvClassName.setText(attendance.getClassName());
        holder.tvLecture.setText(attendance.getTotalLectures());
        holder.tvPresent.setText(attendance.getPresent());
        holder.tvSick.setText(attendance.getSick());
        holder.tvAbsent.setText(attendance.getAbsent());
        holder.tvLate.setText(attendance.getLate());
    }

    @Override
    public int getItemCount() {
        return attendanceList.size();
    }

    class AttendanceViewHolder extends RecyclerView.ViewHolder {

        TextView tvClassName, tvLecture, tvPresent, tvAbsent, tvSick, tvLate;

        public AttendanceViewHolder(View itemView){
            super(itemView);

            tvClassName = itemView.findViewById(R.id.className);
            tvLecture = itemView.findViewById(R.id.lecture);
            tvPresent = itemView.findViewById(R.id.present);
            tvSick = itemView.findViewById(R.id.sick);
            tvAbsent = itemView.findViewById(R.id.absent);
            tvLate = itemView.findViewById(R.id.late);
        }
    }
}
