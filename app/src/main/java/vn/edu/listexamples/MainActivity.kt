package vn.edu.listexamples

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val items = mutableListOf<ImageModel>()
    repeat(28) {
      items.add(ImageModel(
        "Image $it",
        resources.getIdentifier("thumb$it", "drawable", packageName),
        resources.getIdentifier("wall$it", "drawable", packageName),
      ))
    }

    val layoutList = findViewById<LinearLayout>(R.id.layout_list)
    val imageLarge = findViewById<ImageView>(R.id.image_large)

    for(item in items) {
      val itemView = layoutInflater.inflate(R.layout.layout_image_item, layoutList, false)
      itemView.findViewById<TextView>(R.id.text_caption).text = item.caption
      itemView.findViewById<ImageView>(R.id.image_thumb).setImageResource(item.thumbId)
      layoutList.addView(itemView)

      itemView.setOnClickListener {
        imageLarge.setImageResource(item.imageId)
      }
    }
  }
}