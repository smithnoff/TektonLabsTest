package com.smithnoff.cesarsmith.tektonlabstest.ui.view.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.smithnoff.cesarsmith.tektonlabstest.R
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.EventFeed
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.User
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.DetailsCallback
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.interactors.DetailsPresenter
import com.smithnoff.cesarsmith.tektonlabstest.ui.view.adapters.SuscribersAdapter
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.content_details.*

class DetailsActivity : AppCompatActivity(),DetailsCallback.View {
 lateinit var presenter:DetailsCallback.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setSupportActionBar(toolbar)
        presenter=DetailsPresenter(this)
        var feed=intent.getSerializableExtra("evento") as EventFeed
        this.title=feed.title
        tv_place_detail.text=feed.place
        tv_date_detail.text=feed.date
        tv_hour_detail.text=feed.time
        fab.setOnClickListener {
            startActivity(Intent(this,MapsActivity::class.java))
        }
        recycler_suscribers.layoutManager=LinearLayoutManager(this)
        recycler_suscribers.adapter=SuscribersAdapter(this, mutableListOf())
        recycler_suscribers.adapter.notifyDataSetChanged()

      presenter.callSuscribers(feed.id)

    }
    override fun showErrors(msg: String, action: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSuscribers(list: MutableList<User>) {
        recycler_suscribers.adapter=SuscribersAdapter(this, list)
        recycler_suscribers.adapter.notifyDataSetChanged()
    }

}
