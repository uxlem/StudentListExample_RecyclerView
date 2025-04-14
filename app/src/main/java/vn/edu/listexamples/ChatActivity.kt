package vn.edu.listexamples

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChatActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_chat)

    val messages = mutableListOf<ChatModel>()
    messages.add(ChatModel("me", "Xin chao", R.drawable.thumb0))
    messages.add(ChatModel("user1", "Chao ban", R.drawable.thumb1))
    messages.add(ChatModel("me", "Ban co khoe khong?", R.drawable.thumb0))
    messages.add(ChatModel("user1", "Minh khoe", R.drawable.thumb1))

    val adapter = ChatAdapter(messages)
    val listMessages = findViewById<ListView>(R.id.list_chats)
    listMessages.adapter = adapter
  }
}