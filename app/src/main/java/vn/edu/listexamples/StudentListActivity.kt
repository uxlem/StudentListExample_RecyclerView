package vn.edu.listexamples

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StudentListActivity : AppCompatActivity() {
  lateinit var button_add : Button
  lateinit var editHoten : EditText
  lateinit var editMSSV: EditText
  lateinit var adapter: StudentAdapter
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_student_list)

    val students = mutableListOf<StudentModel>()
    repeat(28) {
      students.add(StudentModel(
        "Student $it",
        "SV$it"
      ))
    }

    adapter = StudentAdapter(students, object: StudentAdapter.ButtonClickListener{
      override fun onButtonClicked(position: Int) {
        students.removeAt(position)
        adapter.notifyDataSetChanged()
      }
    })

    val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
    recyclerView.adapter = adapter
    recyclerView.layoutManager = LinearLayoutManager(this)

    button_add = findViewById(R.id.button_add)
    editMSSV = findViewById(R.id.editMSSV)
    editHoten = findViewById(R.id.editHoten)

    button_add.setOnClickListener({
      if (editMSSV.text.toString() != "" && editHoten.text.toString() != ""){
        students.add(StudentModel(editHoten.text.toString(), editMSSV.text.toString()))
        adapter.notifyDataSetChanged()

      }
    })

//    findViewById<Button>(R.id.button_delete).setOnClickListener {
//      items.removeAt(1)
//      adapter.notifyItemRemoved(1)
//    }
  }
}