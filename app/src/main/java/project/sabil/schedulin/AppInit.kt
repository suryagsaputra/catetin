package project.sabil.schedulin

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import org.koin.android.ext.android.startKoin
import project.sabil.schedulin.base.baseModule

class AppInit : Application(), Application.ActivityLifecycleCallbacks {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin(
                this,
                listOf(baseModule)
        )
    }

    override fun onActivityPaused(activity: Activity?) {
        Log.d("onActivityPaused:", activity?.localClassName)
    }

    override fun onActivityResumed(activity: Activity?) {
        Log.d("onActivityResumed:", activity?.localClassName)
    }

    override fun onActivityStarted(activity: Activity?) {
        Log.d("onActivityStarted:", activity?.localClassName)
    }

    override fun onActivityDestroyed(activity: Activity?) {
        Log.d("onActivityDestroyed:", activity?.localClassName)
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        Log.d("onActivitySaveInstance", activity?.localClassName)
    }

    override fun onActivityStopped(activity: Activity?) {
        Log.d("onActivityStopped:", activity?.localClassName)
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        Log.d("onActivityCreated:", activity?.localClassName)
    }

}