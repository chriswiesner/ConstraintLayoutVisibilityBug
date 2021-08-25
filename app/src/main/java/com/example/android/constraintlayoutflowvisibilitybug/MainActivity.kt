package com.example.android.constraintlayoutflowvisibilitybug

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val root = findViewById<ConstraintLayout>(R.id.root)
        val flow = findViewById<Flow>(R.id.bottom_flow)

        // hide additional info on bottom
        flow.isVisible = false

        // update constraint of top flow
        ConstraintSet().apply {
            clone(root)
            setVerticalBias(R.id.top_flow, 0.5f)
            applyTo(root)
        }


        // ERROR -> now buttom flow is visible again

    }
}