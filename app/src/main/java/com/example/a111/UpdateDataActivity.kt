package com.example.a111

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class UpdateDataActivity : AppCompatActivity() {
    lateinit var name_tv: EditText
    lateinit var standard_tv: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_data)
        name_tv=findViewById(R.id.name_tv)
        standard_tv=findViewById(R.id.standard_tv)
    }

    fun showData(view: View) {}
    fun updateData(view: View) {}
}