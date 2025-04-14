package vn.edu.listexamples

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ChatAdapter(val messages: List<ChatModel>): BaseAdapter() {
  override fun getCount() = messages.size

  override fun getViewTypeCount() = 2

  override fun getItemViewType(position: Int) =
    if (messages[position].username == "me")
      0
    else
      1

  override fun getItem(p0: Int) = messages[p0]

  override fun getItemId(p0: Int) = p0.toLong()

  override fun getView(
    p0: Int,
    p1: View?,
    p2: ViewGroup?,
  ): View? {
    val itemView: View
    val viewHolder: ViewHolder

    if (p1 == null) {
      if (getItemViewType(p0) == 0)
        itemView = LayoutInflater.from(p2?.context).inflate(R.layout.layout_right_item, p2, false)
      else
        itemView = LayoutInflater.from(p2?.context).inflate(R.layout.layout_left_item, p2, false)

      viewHolder = ViewHolder()
      viewHolder.imageAvatar = itemView.findViewById<ImageView>(R.id.image_thumb)
      viewHolder.textCaption = itemView.findViewById<TextView>(R.id.text_caption)
      itemView.tag = viewHolder
    } else {
      itemView = p1
      viewHolder = p1.tag as ViewHolder
    }

    val message = messages[p0]
    viewHolder.imageAvatar.setImageResource(message.avatarResId)
    viewHolder.textCaption.text = message.message

    return itemView
  }

  class ViewHolder {
    lateinit var imageAvatar: ImageView
    lateinit var textCaption: TextView
  }
}