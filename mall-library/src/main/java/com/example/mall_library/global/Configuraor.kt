package com.example.mall_library.global

import com.example.mall_library.util.storage.MemoryStore
import android.os.Handler
import java.lang.RuntimeException

//全局配置类 加了private constructor之后不能new
class Configuraor private constructor(){
    private  object  Holder{
        internal  val INSTANCE = Configuraor()
    }
    companion object {
//        得到全局的存储容器
        private  val mStore:MemoryStore = MemoryStore.instance
//        Handler需要反复使用，不妨提前创建
        private  val mHandler = Handler()
        internal  val instance:Configuraor
        get() = Holder.INSTANCE
    }
//    开始自动执行设置初始化为false
    init {
//        加一个标签，还没开始配置,判断是否配置完成
        mStore.addData(GlobalKeys.IS_CONFIGURE_READY, false)
        mStore.addData(GlobalKeys.HANDLER, mHandler)
    }
//    访问服务器api设置
    fun withApiHost(host:String):Configuraor {
        mStore.addData(GlobalKeys.API_HOST,host)
       return this
    }
//    结束配置
    fun configure() {
       mStore.addData(GlobalKeys.IS_CONFIGURE_READY,true)
//        下面可以做一些回收动作
    }
    private fun checkConfiguration () {
        val isReady = mStore.getData<Boolean>(GlobalKeys.IS_CONFIGURE_READY)
        if (!isReady) {
            throw  RuntimeException("config is not ready！")
        }
    }
    fun <T>getConfiguration(key:String):T{
        checkConfiguration()
        return mStore.getData(key)
    }
    fun <T>getConfiguration(key:Enum<*>):T{
        checkConfiguration()
        return getConfiguration(key.name)
    }
}