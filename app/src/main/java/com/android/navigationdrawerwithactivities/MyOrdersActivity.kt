package com.android.navigationdrawerwithactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MyOrdersActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_my_orders)
        setContentLayout(R.layout.activity_my_orders)
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0,0)
    }
}
