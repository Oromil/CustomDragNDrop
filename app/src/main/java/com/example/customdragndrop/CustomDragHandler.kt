package com.example.customdragndrop

import android.view.View

class CustomDragHandler {

    fun startDrag(view: View){
        view.setOnDragListener { v, event ->

            true
        }
    }
}