package project.sabil.schedulin.base

import com.trello.navi2.Event
import com.trello.navi2.component.support.NaviAppCompatActivity
import com.trello.navi2.rx.RxNavi
import io.reactivex.android.schedulers.AndroidSchedulers

abstract class BaseActivity : NaviAppCompatActivity() {

    protected fun initLayout(view: Int) {
        RxNavi
                .observe(this, Event.CREATE)
                .observeOn(AndroidSchedulers.mainThread())
                .takeUntil(RxNavi.observe(this, Event.DESTROY))
                .subscribe { setContentView(view) }
    }

}