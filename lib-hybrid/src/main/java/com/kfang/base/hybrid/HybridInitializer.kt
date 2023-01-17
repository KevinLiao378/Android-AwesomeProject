package com.kfang.base.hybrid

import android.app.Application
import android.content.Context
import com.facebook.react.ReactApplication
import com.facebook.react.ReactInstanceManager
import com.facebook.soloader.SoLoader
import java.lang.reflect.InvocationTargetException

/**
 * @author liaoyi
 * @date 2023/1/17
 */
object HybridInitializer {

    fun init(application: Application) {
        SoLoader.init(application, false)
        initializeFlipper(application)
    }

    private fun initializeFlipper(
        context: Application
    ) {
        if (BuildConfig.DEBUG && context is ReactApplication) {
            try {
                val aClass = Class.forName("com.kfang.base.hybrid.ReactNativeFlipper")
                aClass.getMethod("initializeFlipper", Context::class.java, ReactInstanceManager::class.java)
                    .invoke(null, context, context.reactNativeHost.reactInstanceManager)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: NoSuchMethodException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InvocationTargetException) {
                e.printStackTrace()
            }
        }
    }
}