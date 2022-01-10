package com.zaid.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawer_layout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var nav_view: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawer_layout = findViewById(R.id.drawer_layout)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        nav_view = findViewById(R.id.nav_view)
        val navController = Navigation.findNavController(this,R.id.fragment_container)
        NavigationUI.setupWithNavController(nav_view, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout)

        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        } else(
            super.onBackPressed()
        )

    }
}