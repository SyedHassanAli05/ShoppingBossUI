package com.myapplication.shoppingboss.ModelClasses

import com.myapplication.shoppingboss.R

class RewardTopModel {

    constructor(title: String, colorSelected: Int?, color: Int?) {

        this.title = title
        this.colorSelected = colorSelected
        this.color = color

    }

    constructor(title: String, colorSelected: String, color: Int)

    var title = "ALL"
    var colorSelected: Int? = R.color.deep_sky_blue
    var color: Int? = android.R.color.black
}