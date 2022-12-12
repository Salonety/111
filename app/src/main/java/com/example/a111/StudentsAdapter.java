package com.example.a111;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Databases.StudentTable;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ViewHolder> {
    Context context;
    List<StudentTable>  studentTableList;
    View view;

    public StudentsAdapter(Context context) {
        this.context = context;
    }

    public StudentsAdapter(Context context, List<StudentTable> studentTableList) {
        this.context = context;
        this.studentTableList = studentTableList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(context).inflate(R.layout.rv_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (studentTableList!=null && studentTableList.size()>0){
            StudentTable studentTable = studentTableList.get(position);
            holder.roll_no_tv.setText(String.valueOf(studentTable.getId()));
            holder.name_tv.setText(studentTable.getStu_name());
            holder.standard_tv.setText(studentTable.getStu_standard());


        }

    }

    @Override
    public int getItemCount() {
        return studentTableList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView roll_no_tv,name_tv,standard_tv,email;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            roll_no_tv=itemView.findViewById(R.id.roll_no_tv);
            name_tv=itemView.findViewById(R.id.name_tv);
            standard_tv=itemView.findViewById(R.id.standard_tv);
            email=itemView.findViewById(R.id.email);

        }
    }
}
