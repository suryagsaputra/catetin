package project.sabil.schedulin

import com.trello.navi2.Event
import com.trello.navi2.rx.RxNavi
import io.reactivex.android.schedulers.AndroidSchedulers
import project.sabil.schedulin.base.BaseActivity

class MainActivity : BaseActivity() {

    init {
        initLayout()
    }

    private fun initLayout() {
        RxNavi
                .observe(this, Event.CREATE)
                .observeOn(AndroidSchedulers.mainThread())
                .takeUntil(RxNavi.observe(this, Event.DESTROY))
                .subscribe { setContentView(R.layout.login_activity) }
    }
}
