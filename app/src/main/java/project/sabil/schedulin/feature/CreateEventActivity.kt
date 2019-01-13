package project.sabil.schedulin.feature

import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.jakewharton.rxbinding3.view.clicks
import com.trello.navi2.Event
import com.trello.navi2.rx.RxNavi
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_create_event.*
import project.sabil.schedulin.MainActivity
import project.sabil.schedulin.R
import project.sabil.schedulin.base.BaseActivity

class CreateEventActivity : BaseActivity() {
    //private val zone: Array<String> = baseContext.resources.getStringArray(R.array.zone)

    init {
        initLayout(R.layout.activity_create_event)
        initZoneSpinner()
        initCreateEventButton()
    }

    private fun initZoneSpinner() {
        RxNavi
                .observe(this, Event.CREATE)
                .observeOn(AndroidSchedulers.mainThread())
                .takeUntil(RxNavi.observe(this, Event.DESTROY))
                .subscribe { initZoneAdapter() }
    }

    private fun initZoneAdapter() {
        val spinner: Spinner = findViewById(R.id.event_zone_spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
                this,
                R.array.zone,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }

    private fun initCreateEventButton() {
        RxNavi
                .observe(this, Event.CREATE)
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { event_create_event_button.clicks() }
                .takeUntil(RxNavi.observe(this, Event.DESTROY))
                .subscribe { startMainActivity() }
    }

    private fun startMainActivity() {
        val zone: Array<String> = baseContext.resources.getStringArray(R.array.zone)
        val intent = Intent(this, MainActivity::class.java)
                .apply {
                    putExtra(MainActivity.INTENT_EVENT_NAME, event_name_edit_text.text.toString())
                    putExtra(MainActivity.INTENT_EVENT_ZONE, zone[event_zone_spinner.selectedItemPosition])
                }
        startActivity(intent)
    }

}