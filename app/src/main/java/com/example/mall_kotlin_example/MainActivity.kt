package com.example.mall_kotlin_example

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mall_library.global.GlobalKeys
import com.example.mall_library.global.Mall

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Mall.getConfiguration<Context>(GlobalKeys.APPLICATION_CONTEXT)
    }
}
