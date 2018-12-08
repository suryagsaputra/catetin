package project.sabil.schedulin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.amazonaws.mobile.client.AWSMobileClient


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        AWSMobileClient.getInstance().initialize(this) {
            Log.d("YourMainActivity", "AWSMobileClient is instantiated and you are connected to AWS!")
        }.execute()

    }
}
