package com.smithnoff.cesarsmith.tektonlabstest.ui.view.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.smithnoff.cesarsmith.tektonlabstest.R
import com.smithnoff.cesarsmith.tektonlabstest.ui.view.fragments.EventsFragment
import com.smithnoff.cesarsmith.tektonlabstest.ui.view.fragments.MyEventsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var fragment= Fragment()
    lateinit var transaction:FragmentTransaction

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        transaction=supportFragmentManager.beginTransaction()

        when (item.itemId) {
            R.id.navigation_home -> {
                fragment=EventsFragment()
                transaction.replace(R.id.fragment_layout,fragment).commit()

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                fragment=MyEventsFragment()
                transaction.replace(R.id.fragment_layout,fragment).commit()
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment=EventsFragment()
        transaction=supportFragmentManager.beginTransaction()

        transaction.replace(R.id.fragment_layout,fragment).commit()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_details, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.action_settings->{
                startActivity(Intent(this,LoginActivity::class.java))
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
