package com.android.navigationdrawerwithactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SearchActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_search)
        setContentLayout(R.layout.activity_search)
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0,0)
    }
}
