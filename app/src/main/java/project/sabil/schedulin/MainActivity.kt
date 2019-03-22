package project.sabil.schedulin

import com.jakewharton.rxbinding3.widget.textChanges
import com.trello.navi2.Event
import com.trello.navi2.rx.RxNavi
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import project.sabil.schedulin.base.BaseActivity
import java.util.concurrent.TimeUnit

class MainActivity : BaseActivity() {

    private val eventName: String by lazy {
        intent.getStringExtra(INTENT_EVENT_NAME)
    }

    private val eventZone: String by lazy {
        intent.getStringExtra(INTENT_EVENT_ZONE)
    }

    init {
        initLayout(R.layout.activity_main)
        initUsername()
        initUserIdListener()
    }

    private fun initUsername() {
        RxNavi
                .observe(this, Event.CREATE)
                .observeOn(AndroidSchedulers.mainThread())
                .takeUntil(RxNavi.observe(this, Event.DESTROY))
                .subscribe {
                    dashboard_username.text = "$eventName | $eventZone"
                }
    }

    private fun initUserIdListener() {
        RxNavi
                .observe(this, Event.CREATE)
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { dashboard_user_id.textChanges() }
                .timeout(1, TimeUnit.HOURS)
                .takeUntil(RxNavi.observe(this, Event.DESTROY))
                .subscribe {
                    dashboard_username.text = it.toString()
                }
    }

    companion object {
        const val INTENT_EVENT_NAME = "intent.event_name"
        const val INTENT_EVENT_ZONE = "intent.event_zone"
    }
}
