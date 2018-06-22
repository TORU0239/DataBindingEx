package my.com.toru.databindingex.ui

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import my.com.toru.databindingex.R
import my.com.toru.databindingex.viewmodel.AbsViewModel
import my.com.toru.databindingex.viewmodel.MainViewModel

class MainActivity : BaseActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView:NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.mainToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_outline_menu_24px)
        }

        drawerLayout= findViewById(R.id.mainDrawerLayout)
        drawerLayout.apply {
            addDrawerListener(object:DrawerLayout.DrawerListener{
                override fun onDrawerStateChanged(newState: Int) {}

                override fun onDrawerSlide(drawerView: View, slideOffset: Float) {}

                override fun onDrawerClosed(drawerView: View) {}

                override fun onDrawerOpened(drawerView: View) {}
            })
        }

        navigationView = findViewById(R.id.mainNavigationView)
        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.main_nav_list-> {
                    Toast.makeText(MainActivity@this, "NAV LIST", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(navigationView)
                    true
                }

                R.id.main_nav_faq-> {
                    Toast.makeText(MainActivity@this, "NAV FAQ", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(navigationView)
                    true
                }
                R.id.main_nav_setting-> {
                    Toast.makeText(MainActivity@this, "NAV SETTING", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(navigationView)
                    true
                }
                R.id.main_nav_need_help-> {
                    Toast.makeText(MainActivity@this, "NAV NEED HELP", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(navigationView)
                    true
                }
                else->false
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId){
            android.R.id.home->{
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else-> return super.onOptionsItemSelected(item)
        }
    }

    override fun initViewModel(): AbsViewModel = MainViewModel()
}