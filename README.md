# GridViewWithGroupie


![Alt Text](https://media.giphy.com/media/dAdBNFG0CS2kuimLcC/giphy.gif)



### RecyclerView
You have to manage so many things – create adapters, keep track of multiple view types and span sizes (when you’re using a GridLayoutManager). 
Let’s not forget that sometimes you want to use expandable groups with headers… Oh and you also have to manage your overall sanity when something breaks in the process!

Luckily there is a simple RecyclerView solution which works out-of-the-box but it can also be heavily customized if you want 
to play with it. Groupie is an open-source Android library aimed at helping you get rid of any RecyclerView related headaches.

### Libraries
    implementation "com.xwray:groupie:2.4.0"
    implementation "com.xwray:groupie-kotlin-android-extensions:2.4.0"

Do not forget to add below in you build.gradle(App level)
This is used to enable the view caching from viewholders.

    androidExtensions {
      experimental = true
    }


### Create Items for your List

Groupie abstracts away the complexity of multiple item view types. Each Item declares a view layout id, and gets a 
callback to bind the inflated layout. That's all you need; you can add your new item directly to a GroupAdapter and call it 
a day.

### Create Header 
The Header view also needs simple Item layout as given above. And  `ExpandableItem` Interface should be implemented. That will gives you the 
`setExpandableGroup` method which is used to handle the Expand and Collapse. 

Finally you have to send data from your activity or fragment to the Header and Item like below,

       //Expandable Group setup for 4 items
        ExpandableGroup(HeaderItem("Numbers 1"), true).apply {
            add(Section(number1Numbers))
            groupAdapter.add(this)
        }

Thats it guys!

Happie Coding:)
