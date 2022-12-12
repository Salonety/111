package com.example.a111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import Helper.DatabaseHelper;

public class MainActivity extends AppCompatActivity {
    EditText name_tv,standard_tv;
    DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper= DatabaseHelper.getInstance(this);
        name_tv=findViewById(R.id.name_tv);
        standard_tv=findViewById(R.id.standard_tv);


    }

    public void submitData(View view) {
        if(!name_tv.getText().toString().isEmpty()&&!standard_tv.getText().toString().isEmpty());
        helper.addNewStudent(name_tv.getText().toString(),standard_tv.getText().toString());
    }

    public void showData(View view) {
        startActivity(new Intent(this,DataViewerActivity.class));

    }
}