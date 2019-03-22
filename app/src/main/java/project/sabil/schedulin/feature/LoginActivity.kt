package project.sabil.schedulin.feature

import android.content.Intent
import com.jakewharton.rxbinding3.view.clicks
import com.trello.navi2.Event
import com.trello.navi2.rx.RxNavi
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.login_activity.*
import project.sabil.schedulin.MainActivity
import project.sabil.schedulin.R
import project.sabil.schedulin.base.BaseActivity

class LoginActivity : BaseActivity() {

    init {
        initLayout(R.layout.login_activity)
        initSubmitButton()
    }

    private fun initSubmitButton() {
        RxNavi
                .observe(this, Event.CREATE)
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { login_confirm.clicks() }
                .filter { validateUser() }
                .takeUntil(RxNavi.observe(this, Event.DESTROY))
                .subscribe {
                    startMainActivity()
                }
    }

    private fun validateUser(): Boolean {
        return login_username.text.toString() == "admin" &&
                login_password.text.toString() == "123456"
    }

    private fun startMainActivity() {
        val intent = Intent(this, CreateEventActivity::class.java)
        startActivity(intent)
    }
}