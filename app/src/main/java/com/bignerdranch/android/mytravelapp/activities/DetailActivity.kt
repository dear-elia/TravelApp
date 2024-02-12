package com.bignerdranch.android.mytravelapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bignerdranch.android.mytravelapp.R
import android.widget.TextView
import com.bignerdranch.android.mytravelapp.Domains.PopularDomain
import com.bumptech.glide.Glide


class DetailActivity : AppCompatActivity() {
    private lateinit var titleTxt: TextView
    private lateinit var locationTxt: TextView
    private lateinit var bedTxt: TextView
    private lateinit var guideTxt: TextView
    private lateinit var wifiTxt: TextView
    private lateinit var descriptionTxt: TextView
    private lateinit var scoreTxt:TextView
    private lateinit var item: PopularDomain
    private lateinit var picImg: ImageView
    private lateinit var backBtn: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initview()
        setVariable()
    }
    private fun setVariable(){

        //set the values of the UI components of the detail activity layout
        //based on the values of PopularDomain
        //getSerializableExtra() method is used to retrieve the PopularDomain object
        //that was passed from the MainActivity using the key "object".

        item = intent.getSerializableExtra("object") as PopularDomain
        titleTxt.text = item.title
        scoreTxt.text = item.score.toString()
        locationTxt.text = item.location

        //concatenate the value of item.bed with the string " bed".
        bedTxt.text = "${item.bed} beds"
        descriptionTxt.text = item.description

        if (item.isGuide()) {
            guideTxt.setText(R.string.guideoption)
        } else {
            guideTxt.setText(R.string.NoGuideOption)
        }

        if (item.isWifi()) {
            wifiTxt.setText(R.string.wifiOption)
        } else {
            wifiTxt.setText(R.string.noWifiOption)
        }

        //set the image for an item being displayed
        val drawableResId = resources.getIdentifier(item.pic, "drawable", packageName)

        //use the Glide library to load the image with the resource identifier
        Glide.with(this)
            .load(drawableResId)
            .into(picImg)

        //click listener for back button to finish activity and return to MainActivity
        backBtn.setOnClickListener { finish() }
    }
    private fun initview(){
        titleTxt = findViewById(R.id.titleHouseTxt)
        locationTxt = findViewById(R.id.locationTxt)
        bedTxt = findViewById(R.id.bedTxt)
        guideTxt = findViewById(R.id.guideTxt)
        wifiTxt = findViewById(R.id.wifiTxt)
        descriptionTxt = findViewById(R.id.descriptionTxt)
        scoreTxt = findViewById(R.id.scoreTxt)
        picImg = findViewById(R.id.imagePicforhouse)
        backBtn= findViewById(R.id.backBtn)
    }
}