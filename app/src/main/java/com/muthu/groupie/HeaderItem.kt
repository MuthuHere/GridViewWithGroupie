package com.muthu.groupie

import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_header_view.*

class HeaderItem(
    private val title: String
) : Item(), ExpandableItem {

    private lateinit var expandableGroup: ExpandableGroup


    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        this.expandableGroup = onToggleListener
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvHeaderTitle.text = title

        viewHolder.itemHeaderRoot.setOnClickListener {
            expandableGroup.onToggleExpanded()
            viewHolder.item_expandable_header_icon.setImageResource(getRotatedIconResId())
        }

    }

    override fun getLayout() = R.layout.item_header_view

    private fun getRotatedIconResId() =
        if (expandableGroup.isExpanded)
            R.drawable.ic_arrow_drop_up
        else
            R.drawable.ic_arrow_drop_down

}