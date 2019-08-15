package com.muthu.groupie

import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_numbers.*


class NumberItems(
    private val color: Int,
    private val number: Int
) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {

        viewHolder.item_number.text = number.toString()
        viewHolder.cvItemRoot.setCardBackgroundColor(color)
    }

    override fun getLayout() = R.layout.item_numbers


    override fun getSpanSize(spanCount: Int, position: Int) = spanCount / 3
}