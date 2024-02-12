package com.bignerdranch.android.mytravelapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.mytravelapp.Adapters.CategoryAdapter
import com.bignerdranch.android.mytravelapp.Adapters.PopularAdapter
import com.bignerdranch.android.mytravelapp.Domains.PopularDomain
import com.bignerdranch.android.mytravelapp.Domains.categoryDomain
import com.bignerdranch.android.mytravelapp.R

class MainActivity : AppCompatActivity() {
    private lateinit var adapterPopular: RecyclerView.Adapter<*>
    private lateinit var adapterCat: RecyclerView.Adapter<*>
    private lateinit var recyclerViewPopular: RecyclerView
    private lateinit var recyclerViewCategory: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView() {

        //PopularDomain is a class
        // we're creating an instance of an ArrayList.
        //<PopularDomain> specifies the type of elements that the ArrayList will contain.

        val items = ArrayList<PopularDomain>()
        items.add(PopularDomain("Jeju Family Garden Village", "Jeju Island", "2.5 km from Aljakji Beach. " +
                "Jeju Family Garden Village is a recently renovated property located in Jeju and " +
                "provides air-conditioned rooms with free WiFi and private parking. " +
                "The accommodation has a spa bath. The holiday home features a plunge pool with a pool bar " +
                "as well as a hot tub and full-day security.",
            2, true, 4.9, "jejuvillage", true, 1000))
        items.add(PopularDomain("LOTTE City Hotel Jeju", "centre of Jeju City", "the 4-star LOTTE City Hotel Jeju feature a fitness centre and a sauna. " +
                "Free WiFi and free parking are available at the property. " +
                "LOTTE City Hotel Jeju also offers a drop-off service to Jeju International Airport. " +
                "Air-conditioned rooms provides a flat-screen TV, " +
                "a refrigerator and an electric kettle. Each room is fitted with a desk " +
                "and a private bathroom with a bath and free toiletries. ", 1, false, 5.0, "jeju2", false, 2500))
        items.add(PopularDomain("Halole Marko", "Jeju-do", "A boutique hotel on the beachfront of Waikiki in Hawaii," +
                "Attractively set in the centre of Jeju, Grand Hyatt Jeju features air-conditioned rooms with free WiFi, " +
                "free private parking and room service. " +
                "This 5-star resort offers a 24-hour front desk and an ATM.  " +
                "The property has a year-round outdoor pool, indoor pool, fitness centre and restaurant. " +
                "A buffet, à la carte or continental breakfast is available each morning.", 3, true, 4.3, "jeju3", true, 30000))

        //first, we find the RecyclerView's ID
        recyclerViewPopular = findViewById(R.id.view_pop)

        //LinearLayoutManager is set as the layout manager for the RecyclerView.
        /*
        * this: Refers to the current context (usually an Activity).
        * horizontal: RecyclerView will display its items in a horizontal row.
        * false: the layout will not be reversed.*/
        recyclerViewPopular.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        //PopularAdapter is a class, that we imported
        //PopularAdapter(items) - We create an instance of PopularAdapter, and pass 'items' as constructor's parameter
        adapterPopular = PopularAdapter(items)

        //the adapter (adapterPopular) is set on the RecyclerView (recyclerViewPopular).
        //recyclerViewPopular: This refers to the RecyclerView component in your layout activity_main.xml
        //.adapter: set adapter on RecyclerView
        //adapterPopular: an instance of PopularAdapter class
        //This tells the RecyclerView to use your adapter to display the data and
        //create the visual representation (views) for each item in the list.
        recyclerViewPopular.adapter = adapterPopular

        //ArrayList with type CategoryDomain
        val catsItems = ArrayList<categoryDomain>()
        catsItems.add(categoryDomain("Beaches", "cat1"))
        catsItems.add(categoryDomain("Camps", "cat2"))
        catsItems.add(categoryDomain("Forest", "cat3"))
        catsItems.add(categoryDomain("Desert", "cat4"))
        catsItems.add(categoryDomain("Mountain", "cat5"))

        recyclerViewCategory = findViewById(R.id.view_cat)
        recyclerViewCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        //pass catsItems as parameter to constructor
        adapterCat = CategoryAdapter(catsItems)

        //we tell recyclerview to use adapter and display data for each item in the list
        recyclerViewCategory.adapter = adapterCat

    }
}
