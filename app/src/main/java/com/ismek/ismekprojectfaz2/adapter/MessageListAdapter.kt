package com.ismek.ismekprojectfaz2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ismek.ismekprojectfaz2.R
import com.ismek.ismekprojectfaz2.model.MessageData
import kotlinx.android.synthetic.main.message_item_layout.view.*

class MessageListAdapter : RecyclerView.Adapter<MessageListAdapter.MessageViewHolder>() {

    private var messageList: ArrayList<MessageData> = arrayListOf()
    var messageItemClickListener : (MessageData) -> Unit = {} //Lambda listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
       return MessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.message_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messageList[position])
    }

    override fun getItemCount(): Int = messageList.size


    inner class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(messageData: MessageData) {
            itemView.apply {
                with(messageData){
                    tv_user_name.text = messagePersonName
                    tv_user_message.text = messagePersonLastMessage
                    tv_user_message_time.text = messageTime
                    tv_message_count.text = messageCount.toString()
                    itemView.main_layout.setOnClickListener {
                       messageItemClickListener(messageData)
                    }
                    if (messageCount > 10){
                        tv_message_count.background = ContextCompat.getDrawable(tv_message_count.context, R.drawable.message_count_badge_important_background)
                    }
                }
            }
        }
    }

    fun setMessageList(tempMessageList: ArrayList<MessageData>){
        messageList.addAll(tempMessageList)
        notifyDataSetChanged()
    }
}