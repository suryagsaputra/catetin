package project.sabil.schedulin

import android.util.Log
import com.amazonaws.mobile.client.AWSMobileClient
import com.trello.navi2.Event
import com.trello.navi2.component.support.NaviAppCompatActivity
import com.trello.navi2.rx.RxNavi
import io.reactivex.android.schedulers.AndroidSchedulers

class MainActivity : NaviAppCompatActivity() {

    init {
        RxNavi
                .observe(this, Event.CREATE)
                .observeOn(AndroidSchedulers.mainThread())
                .takeUntil(RxNavi.observe(this, Event.DESTROY))
                .subscribe {
                    setContentView(R.layout.login_activity)
                    AWSMobileClient.getInstance().initialize(this) {
                        Log.d("YourMainActivity", "AWSMobileClient is instantiated and you are connected to AWS!")
                    }.execute()
                }
    }
}
