package my.com.toru.databindingex.ui

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.view.View
import my.com.toru.databindingex.R
import my.com.toru.databindingex.viewmodel.AbsViewModel
import my.com.toru.databindingex.viewmodel.MainViewModel

class MainActivity : BaseActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView:NavigationView
    private var currentItemId:Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.w("MainActivity", "onCreate")

        val toolbar = findViewById<Toolbar>(R.id.mainToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_outline_menu_24px)
        }

        navigationView = findViewById(R.id.mainNavigationView)
        navigationView.setNavigationItemSelectedListener {
            currentItemId = it.itemId
            drawerLayout.closeDrawer(navigationView)
            true
        }

        drawerLayout= findViewById(R.id.mainDrawerLayout)
        drawerLayout.apply {
            addDrawerListener(object:DrawerLayout.DrawerListener{
                var current = -1
                override fun onDrawerStateChanged(newState: Int) {}

                override fun onDrawerSlide(drawerView: View, slideOffset: Float) {}

                override fun onDrawerClosed(drawerView: View) {
                    if(current != currentItemId){

                        Log.w("MainActivity", "currentItemId:: $currentItemId")

                        when(currentItemId){
                            R.id.main_nav_list->{
                                currentItemId = R.id.main_nav_list
                                supportFragmentManager.beginTransaction()
                                        .replace(R.id.mainFrame, MainListFragment())
                                        .commit()
                            }

                            R.id.main_nav_faq-> {
                                currentItemId = R.id.main_nav_faq
                                supportFragmentManager.beginTransaction()
                                        .replace(R.id.mainFrame, MainFAQFragment())
                                        .commit()
                            }
                            R.id.main_nav_setting-> {
                                currentItemId = R.id.main_nav_setting
                                supportFragmentManager.beginTransaction()
                                        .replace(R.id.mainFrame, MainSettingFragment())
                                        .commit()

                            }
                            R.id.main_nav_need_help->{
                                currentItemId = R.id.main_nav_need_help
                                supportFragmentManager.beginTransaction()
                                        .replace(R.id.mainFrame, MainNeedHelpFragment())
                                        .commit()
                            }
                            else->{}
                        }
                    }
                }

                override fun onDrawerOpened(drawerView: View) {
                    current = currentItemId
                }
            })
        }

        currentItemId = R.id.main_nav_list
        currentItemId.let {
            navigationView.setCheckedItem(it)
        }

        supportFragmentManager.beginTransaction()
                .replace(R.id.mainFrame, MainListFragment())
                .commit()
    }

    override fun onResume() {
        super.onResume()
        Log.w("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.w("MainActivity", "onPause")
    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            if(supportFragmentManager.backStackEntryCount > 0 && currentItemId != R.id.main_nav_list){
                supportFragmentManager.popBackStack()
                currentItemId = R.id.main_nav_list
                currentItemId.let {
                    navigationView.setCheckedItem(it)
                }
            }
            else{
                super.onBackPressed()
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