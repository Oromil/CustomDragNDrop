package com.example.customdragndrop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dragger = CustomDragHandler()
        val view = layoutInflater.inflate(R.layout.item, root, false)
        root.addView(view)
        view.btnDrag.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    dragger.startDrag(view)
                    Log.d("MotionEvent", "Action_Down")
                }
                MotionEvent.ACTION_UP -> Log.d("MotionEvent", "Action_Up")
                MotionEvent.ACTION_MOVE -> {
                    Log.d("MotionEvent", "Action_Move; rawX: ${event.rawX}, rawY: ${event.rawY}, X: ${event.x}, Y: ${event.y}")
                    Log.d("MotionEvent", "View position: X - ${view.x}, Y - ${view.y}")
                    view.y = event.rawY - view.height*2
                }
            }

            return@setOnTouchListener true
        }
    }
}
