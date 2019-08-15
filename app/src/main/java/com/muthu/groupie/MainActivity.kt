package com.muthu.groupie

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        val groupAdapter = GroupAdapter<ViewHolder>().apply {
            spanCount = 3
        }

        rvNumberList.apply {
            layoutManager = GridLayoutManager(this@MainActivity, groupAdapter.spanCount).apply {
                spanSizeLookup = groupAdapter.spanSizeLookup
            }
            adapter = groupAdapter
        }

        val number1Numbers = getRandomNumbers(4)
        val number2Numbers = getRandomNumbers(32)

        //Expandable Group setup for 4
        ExpandableGroup(HeaderItem("Numbers 1"), true).apply {
            add(Section(number1Numbers))
            groupAdapter.add(this)
        }
        //Expandable Group setup for 32
        ExpandableGroup(HeaderItem("Numbers 2"), false).apply {
            add(Section(number2Numbers))
            groupAdapter.add(this)
        }


    }

    private fun getRandomNumbers(count: Int): MutableList<NumberItems> {
        val rnd = Random()
        return MutableList(count) {
            val color = Color.argb(
                255, rnd.nextInt(256),
                rnd.nextInt(256), rnd.nextInt(256)
            )
            NumberItems(color, rnd.nextInt(100))
        }
    }

}
