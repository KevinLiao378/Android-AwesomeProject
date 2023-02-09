package com.kfang.base.hybrid

import android.app.Application
import com.facebook.hermes.reactexecutor.HermesExecutor
import com.facebook.hermes.reactexecutor.HermesExecutorFactory
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.JavaScriptExecutorFactory
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

            // https://github.com/facebook/react-native/issues/34089#issuecomment-1299604266
            // 解决 RN0.69.7 开启 Hermes 后 app 闪退问题。
            override fun getJavaScriptExecutorFactory(): JavaScriptExecutorFactory {
                HermesExecutor.loadLibrary()
                return HermesExecutorFactory()
            }
        }
    }
}