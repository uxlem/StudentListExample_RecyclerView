package vn.edu.listexamples

import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GridImageActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_grid_image)

    val items = mutableListOf<Int>()
    repeat(28) { items.add(resources.getIdentifier("thumb$it", "drawable", packageName)) }

    val width = resources.displayMetrics.widthPixels
    val adapter = ImageAdapter(items, width)
    findViewById<GridView>(R.id.grid_image).adapter = adapter
  }
}