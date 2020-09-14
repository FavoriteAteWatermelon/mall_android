package com.example.mall_library.global

import android.content.Context
import com.example.mall_library.util.storage.MemoryStore

object Mall {
    val configuraor:Configuraor
    get() = Configuraor.instance
    fun  init(context:Context):Configuraor {
        MemoryStore.instance
            .addData(GlobalKeys.APPLICATION_CONTEXT,context.applicationContext)
        return Configuraor.instance
    }
    fun <T> getConfiguration(key:String):T{
        return configuraor.getConfiguration(key)
    }
    fun <T> getConfiguration(key:Enum<GlobalKeys>):T{
      return  getConfiguration(key.name)
    }
}