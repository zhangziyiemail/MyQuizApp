package com.example.github.myquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(){

    var sex :String? = null
    var list = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rg.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i -> if (i != null && i >= 1) sex = radioGroup.getChildAt(i-1).tag.toString()})
    }


    fun onCheckboxClicked(view:View){
        when(view){
            cb_android -> if (cb_android.isChecked) list.add(cb_android.tag.toString()) else list.remove(cb_android.tag.toString())
            cb_ios -> if (cb_ios.isChecked) list.add(cb_ios.tag.toString()) else list.remove(cb_ios.tag.toString())
            cb_java -> if (cb_java.isChecked) list.add(cb_java.tag.toString()) else list.remove(cb_java.tag.toString())
        }

    }

    fun submit(view : View){

        Toast.makeText(this,
            "Sex is ${sex} , professional is ${list.toString()}, time is ${SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                .format(Date())}",Toast.LENGTH_SHORT).show()
    }

    fun reset(view: View){
        rg.clearCheck()
        cb_android.isChecked = false
        cb_ios.isChecked = false
        cb_java.isChecked = false

    }
}