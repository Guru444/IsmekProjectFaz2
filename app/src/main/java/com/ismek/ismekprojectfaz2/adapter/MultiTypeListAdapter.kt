package com.ismek.ismekprojectfaz2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ismek.ismekprojectfaz2.R
import kotlinx.android.synthetic.main.button_item_layout.view.*
import kotlinx.android.synthetic.main.textview_item_layout.view.*

class MultiTypeListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var multiTypeList: ArrayList<Boolean> = arrayListOf()
    private var BUTTON = 0
    private var TEXTVIEW = 1
    private var buttonClickListener : (String) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        return when(viewType){
            BUTTON -> {
                TypeButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.button_item_layout, parent, false))
            }
            TEXTVIEW -> {
                TypeTextviewViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.textview_item_layout, parent, false))
            }else ->{
                TypeButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.button_item_layout, parent, false))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == BUTTON){
            (holder as TypeButtonViewHolder).bind(multiTypeList[position])
        }else{
            (holder as TypeTextviewViewHolder).bind(multiTypeList[position])
        }
    }

    override fun getItemCount(): Int = multiTypeList.size

    inner class TypeButtonViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(btn: Boolean) {
            itemView.btn_deneme.text = "Merhaba"
            itemView.btn_deneme.setOnClickListener {

            }
        }
    }
    inner class TypeTextviewViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(b: Boolean) {
            itemView.tv_text.text = "Sanada Merhaba"
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (multiTypeList[position]){
            BUTTON // 0
        }else{
            TEXTVIEW // 1
        }
    }

    fun setBooleanList(listBoolean: ArrayList<Boolean>){
        multiTypeList.addAll(listBoolean)
        notifyDataSetChanged()
    }
}