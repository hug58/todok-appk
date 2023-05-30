package com.example.hugomanager

import android.content.Intent
import android.os.Bundle
import android.util.EventLogTags.Description
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class DetailActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail)

        val bundle = intent.extras
        val title = bundle?.get("INTENT_TITLE").toString()
        val description = bundle?.get("INTENT_DESCRIPTION").toString()
        val id = bundle?.get("INTENT_ID").toString().toInt()
        val done = findViewById<Button>(R.id.buttonDone)



        done.setOnClickListener{
            val name = findViewById<EditText>(R.id.name)
            val descriptionView = findViewById<EditText>(R.id.descrption)

            if (title != "") {
                name.setText(title)
                descriptionView.setText(description)

                todos[id].title = name.text.toString()
                todos[id].description = descriptionView.text.toString()
                println("TEST")
            } else {
                val todo = ToDo(
                    name.text.toString(), descriptionView.text.toString(), ""
                )
                todos.add(todo)
            }


            val intent = Intent(this, MainActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}