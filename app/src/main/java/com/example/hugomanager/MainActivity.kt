package com.example.hugomanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.nio.file.Files.walk


var todos = mutableListOf<ToDo>(
    ToDo("Tasks 2", "neutrones", "https://loremflickr.com/320/240?lock=3"),
    ToDo("Tasks 3", "neutrones", "https://loremflickr.com/320/240?lock=1"),
    ToDo("Tasks 4", "neutrones", "https://loremflickr.com/320/240?lock=2"),

    ToDo("Tasks 4", "neutrones", "https://loremflickr.com/320/240?lock=2"),
    ToDo("Tasks 4", "neutrones", "https://loremflickr.com/320/240?lock=2"),
    ToDo("Tasks 4", "neutrones", "https://loremflickr.com/320/240?lock=2"),
    ToDo("Tasks 4", "neutrones", "https://loremflickr.com/320/240?lock=2"),

    )
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.adapter = TodoAdapter(todos)


        var btnStartAnotherActivity = findViewById<Button>(R.id.addItem)
        btnStartAnotherActivity.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}