package vn.edu.listexamples

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter (val items: List<StudentModel>, val listener: ButtonClickListener? = null): RecyclerView.Adapter<StudentAdapter.ItemViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
    val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_student_item, parent, false)
    return ItemViewHolder(itemView, listener)
  }

  override fun getItemCount() = items.size

  override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
    val item = items[position]
    holder.textMSSV.text = item.mssv
    holder.textHoten.text = item.hoten
  }

  class ItemViewHolder(val itemView: View, val listener: ButtonClickListener? = null): RecyclerView.ViewHolder(itemView) {
    val textMSSV = itemView.findViewById<TextView>(R.id.text_mssv)
    val textHoten = itemView.findViewById<TextView>(R.id.text_hoten)
    val button = itemView.findViewById<Button>(R.id.button)
    init{
      button.setOnClickListener{
        listener?.onButtonClicked(this.adapterPosition)
      }
    }
  }

  interface ButtonClickListener{
    fun onButtonClicked(position: Int){

    }
  }
}
