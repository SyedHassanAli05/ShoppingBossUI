package com.myapplication.shoppingboss.ModelClasses

import com.myapplication.shoppingboss.R

class BottomNavModel {


    constructor(iconSelected: Int, icon: Int?, title: String, colorSelected: Int?, color: Int?) {
        this.iconSelected = iconSelected
        this.icon = icon
        this.title = title
        this.colorSelected = colorSelected
        this.color = color
    }

    var iconSelected: Int? = 0
    var icon: Int? = 0
    var title = ""
    var colorSelected: Int? = R.color.white
    var color: Int? = android.R.color.black
}