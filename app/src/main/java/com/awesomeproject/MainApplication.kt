package com.awesomeproject

import android.app.Application
import com.facebook.react.ReactApplication
import com.facebook.react.ReactNativeHost
import com.kfang.base.hybrid.HybridInitializer
import com.kfang.base.hybrid.ReactNativeHostProvider

/**
 * @author liaoyi
 * @date 2023/1/17
 */
class MainApplication : Application(), ReactApplication {
    override fun getReactNativeHost(): ReactNativeHost {
        return ReactNativeHostProvider.getReactNativeHost(this)
    }

    override fun onCreate() {
        super.onCreate()
        HybridInitializer.init(this)
    }
}