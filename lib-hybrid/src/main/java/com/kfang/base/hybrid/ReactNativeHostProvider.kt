package com.kfang.base.hybrid

import android.app.Application
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.shell.MainReactPackage

/**
 * @author liaoyi
 * @date 2023/1/17
 */
object ReactNativeHostProvider {

    fun getReactNativeHost(context: Application): ReactNativeHost {
        return object : ReactNativeHost(context) {
            override fun getUseDeveloperSupport(): Boolean {
                return BuildConfig.DEBUG
            }

            override fun getJSMainModuleName(): String {
                return "index"
            }

            override fun getPackages(): List<ReactPackage> {
                return listOf(
                    MainReactPackage()
                )
            }
        }
    }
}