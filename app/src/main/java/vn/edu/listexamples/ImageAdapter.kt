package vn.edu.listexamples

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.core.view.setPadding

class ImageAdapter(val items: List<Int>, val screenWidth: Int): BaseAdapter() {
  override fun getCount() = items.size

  override fun getItem(p0: Int) = items[p0]

  override fun getItemId(p0: Int) = p0.toLong()

  override fun getView(
    p0: Int,
    p1: View?,
    p2: ViewGroup?,
  ): View? {
    val imageView = ImageView(p2?.context)
    imageView.layoutParams = ViewGroup.LayoutParams(screenWidth / 3, screenWidth / 3)
    imageView.setImageResource(items[p0])
    imageView.setPadding(5)
    return imageView
  }
}