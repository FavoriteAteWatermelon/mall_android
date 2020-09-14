package com.example.mall_kotlin_example

import android.app.Application
import com.example.mall_library.global.Mall

class MallApp :Application(){
    override fun onCreate() {
        super.onCreate()
        Mall.init(this)

            .withApiHost("http://123.123.com")
            .configure()
    }
}