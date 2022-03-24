package com.ismek.ismekprojectfaz2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ismek.ismekprojectfaz2.adapter.MultiTypeListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var multiTypeListAdapter = MultiTypeListAdapter()
    private var booleanList: ArrayList<Boolean> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        booleanList.add(true)
        booleanList.add(true)
        booleanList.add(false)
        booleanList.add(true)
        booleanList.add(false)
        booleanList.add(true)

        rv_multi_list.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rv_multi_list.adapter = multiTypeListAdapter


        multiTypeListAdapter.setBooleanList(booleanList)

    }
}