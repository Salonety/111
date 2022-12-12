package com.example.a111;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import Databases.StudentTable;
import Helper.DatabaseHelper;

public class DataViewerActivity extends AppCompatActivity {
    RecyclerView recycler_view;
    StudentsAdapter studentsAdapter;
    DatabaseHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_viewer);
        recycler_view=findViewById(R.id.recycler_view);
        helper= DatabaseHelper.getInstance(this);
        helper.getAllStudentsData();

    }

    public void setRecycler_view(List<StudentTable> studentTablesList){
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        studentsAdapter=new StudentsAdapter(this,studentTablesList);
        recycler_view.setAdapter(studentsAdapter);

    }
}