package com.android.navigationdrawerwithactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AboutusActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_aboutus)
        setContentLayout(R.layout.activity_aboutus)
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0,0)
    }
}
