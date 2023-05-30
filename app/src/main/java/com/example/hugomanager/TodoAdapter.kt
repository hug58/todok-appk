package com.example.hugomanager

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.io.File
import java.nio.file.Paths


class TodoAdapter(private val items: MutableList<ToDo>): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    class TodoViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.title)
        private val description = view.findViewById<TextView>(R.id.description)
        private val image = view.findViewById<ImageView>(R.id.image)

        fun bind(todo: ToDo) {
            title.text = todo.title
            description.text = todo.description
            //set image glide
            Glide.with(image.context).load(todo.image).into(image)
        }

        fun checkValue(view: View, id: Int) {
            val intent = Intent(view.context, DetailActivity::class.java)
            intent.putExtra("INTENT_TITLE",title.text)
            intent.putExtra("INTENT_DESCRIPTION",description.text)
            intent.putExtra("INTENT_ID",id.toString())

            view.context.startActivity(intent)

        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TodoViewHolder {
        LayoutInflater.from(p0.context).inflate(R.layout.todo_item, p0, false).apply {
            return TodoViewHolder(this)
        }
    }


    override fun onBindViewHolder(p0: TodoViewHolder, p1: Int) {

       // val path = Paths.get("").toAbsolutePath().toString()
        //File("src/main/res").listFiles().forEach { println(it) }


        val button = p0.itemView.findViewById<Button>(R.id.btnDelete)
        button.setOnClickListener(View.OnClickListener {
            // delete item
            // send notification
            Toast.makeText(p0.itemView.context, "Deleted Id $p1", Toast.LENGTH_SHORT).show()
            items.removeAt(p1)
            notifyItemRemoved(p1)
        })

        val buttonEdit = p0.itemView.findViewById<Button>(R.id.btnEdit)
        buttonEdit.setOnClickListener(View.OnClickListener {
            p0.checkValue(p0.itemView,p1)
        })

        p0.bind(items[p1])



    }

    override fun getItemCount(): Int = items.size
}

