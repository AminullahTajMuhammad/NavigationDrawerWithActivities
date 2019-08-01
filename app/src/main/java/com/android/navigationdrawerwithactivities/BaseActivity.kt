package com.android.navigationdrawerwithactivities

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_base.*

open class BaseActivity : AppCompatActivity() {


    val navigationViewListener2 = object : NavigationView.OnNavigationItemSelectedListener {

        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            val prevNav = getSelectedNav()
            val currentNav = item.itemId

            when(item.itemId) {
                R.id.navSearch -> {
                    val ii = Intent(this@BaseActivity, SearchActivity::class.java)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    startActivity(ii)
//                    overridePendingTransition(0, 0)
                }
                R.id.navMyWallet -> {
                    val ii = Intent(this@BaseActivity, MyWalletActivity::class.java)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    startActivity(ii)
//                    overridePendingTransition(0, 0)
                }
                R.id.navMyOrders -> {
                    val ii = Intent(this@BaseActivity, MyOrdersActivity::class.java)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    startActivity(ii)
//                    overridePendingTransition(0, 0)
                }
                R.id.navAboutUs -> {
                    val ii = Intent(this@BaseActivity, AboutusActivity::class.java)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    startActivity(ii)
//                    overridePendingTransition(0, 0)
                }
            }
            return false
        }

    }

    lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        navigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(navigationViewListener2)
    }

    fun setContentLayout(layoutID: Int): View {
        val contentLayout = findViewById(R.id.frameContainer) as FrameLayout
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return inflater.inflate(layoutID, contentLayout, true)
    }

    fun setSelected(optionID: Int) {
        navigationView.getMenu().findItem(optionID).setChecked(true)
        getSharedPreferences(packageName, MODE_PRIVATE).edit().putInt("selectedNav", optionID)
            .apply()
    }

    fun getSelectedNav(): Int {
        return getSharedPreferences(packageName, MODE_PRIVATE).getInt(
            "selectedNav",
            R.id.navSearch
        )
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0,0)
    }
}
