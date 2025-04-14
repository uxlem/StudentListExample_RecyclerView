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
        adapter.notifyItemRemoved(position)
      }
    })

    val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
    recyclerView.adapter = adapter
    recyclerView.layoutManager = LinearLayoutManager(this)

    button_add = findViewById(R.id.button_add)
    editMSSV = findViewById(R.id.editMSSV)
    editHoten = findViewById(R.id.editHoten)

    button_add.setOnClickListener({
      val name = editHoten.text.toString()
      val mssv = editMSSV.text.toString()
      if (name.isNotEmpty() && mssv.isNotEmpty()) {
        students.add(0, StudentModel(name, mssv))
        adapter.notifyItemInserted(0)
        recyclerView.scrollToPosition(0)

        editHoten.text.clear()
        editMSSV.text.clear()
      }
    })

//    findViewById<Button>(R.id.button_delete).setOnClickListener {
//      items.removeAt(1)
//      adapter.notifyItemRemoved(1)
//    }
  }
}