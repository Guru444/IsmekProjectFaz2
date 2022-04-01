package com.ismek.ismekprojectfaz2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.ismek.ismekprojectfaz2.R
import com.ismek.ismekprojectfaz2.adapter.MessageListAdapter
import com.ismek.ismekprojectfaz2.databinding.ActivityMainBinding
import com.ismek.ismekprojectfaz2.databinding.ActivityMessageListBinding
import com.ismek.ismekprojectfaz2.model.MessageData
import com.ismek.ismekprojectfaz2.util.showSnackBar

class MessageListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMessageListBinding
    private var messageListAdapter = MessageListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val messageList: ArrayList<MessageData> = arrayListOf()

        messageList.apply {
            add(MessageData("image", "Murat Karabulut", "Nasılsınız?","23:30", 1))
            add(MessageData("image", "Mert Tavşan", "naber kanki","17:20", 7))
            add(MessageData("image", "Bahadır Yıldız", "gittin mi eve","20:30", 2))
            add(MessageData("image", "İbrahim Açıcı", "uyudun mu?","03:30", 1))
            add(MessageData("image", "Ali Arslan", "Kiminle konuşuyorsun","23:30", 39))
        }

        binding.apply {
            rvMessageList.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            rvMessageList.adapter = messageListAdapter

            messageListAdapter.setMessageList(messageList)

            messageListAdapter.messageItemClickListener = {
                var intent = Intent(this@MessageListActivity, MessageDetailActivity::class.java)
                startActivity(intent)
                //view.showSnackBar(it.messagePersonName)
            }

            actionButton.setOnClickListener { view ->
                view.showSnackBar("Merhaba ben actionBar")
            }
        }
    }
}