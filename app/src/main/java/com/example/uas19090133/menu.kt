package com.example.uas19090133

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.uas19090133.Fragment.AboutFragment
import com.example.uas19090133.Fragment.DashboardFragment
import com.example.uas19090133.Fragment.RekapFragment
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_menu.*

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val dashboardFragment = DashboardFragment()
        val rekapFragment = RekapFragment()
        val aboutFragment = AboutFragment()

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_open)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        makeCurrentFragment(dashboardFragment)
        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.dashboard -> {
                    makeCurrentFragment(dashboardFragment)
                    toolbar.title = "Dashboard"
                }
                R.id.log ->  {
                    makeCurrentFragment(rekapFragment)
                    toolbar.title = "Rekapitulasi"
                }
                R.id.aboutApp -> {
                    makeCurrentFragment(aboutFragment)
                    toolbar.title = "About Me"
                }
                R.id.logout -> {
                    makeCurrentFragment(dashboardFragment)
                    val b = AlertDialog.Builder(this)
                    b.setTitle("Test")
                    b.setMessage("Do you want to exit?")
                    b.setPositiveButton("yes", { dialog: DialogInterface?, which: Int ->
                        val i = Intent(this, login::class.java)
                        startActivity(i)
                    })
                    b.setNegativeButton("No") { dialog: DialogInterface?, which: Int ->

                    }
                    b.show()
                }
            }

            // auto close nav drawer
            drawer_layout.closeDrawers()
            true
        }

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        } else{
            super.onBackPressed()
        }
    }

    private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}