package com.dicoding.picodiploma.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {
    //use this for parcelable
    private lateinit var user : User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // use this for parcelable
        user = intent.getParcelableExtra(EXTRA_USER) as User



        val tvSetName = findViewById<TextView>(R.id.tv_item_name)
        val tvSetUsername = findViewById<TextView>(R.id.tv_item_username)
        val tvSetCompany = findViewById<TextView>(R.id.tv_item_company)
        val tvSetLocation = findViewById<TextView>(R.id.tv_item_location)
        val imgSetAvatar = findViewById<ImageView>(R.id.img_item_avatar)
        val tvSetRepository = findViewById<TextView>(R.id.tv_item_repository)
        val tvSetFollowers = findViewById<TextView>(R.id.tv_item_followers)
        val tvSetFollowing = findViewById<TextView>(R.id.tv_item_following)

        //this is for non parcelable
//        val tName  = intent.getStringExtra(EXTRA_NAME)
//        val tUsername = intent.getStringExtra(EXTRA_USERNAME)
//        val tCompany = intent.getStringExtra(EXTRA_COMPANY)
//        val tLocation = intent.getStringExtra(EXTRA_LOCATION)
//
//        val tAvatar = intent.getIntExtra(EXTRA_AVATAR,0)
//        val tRepository = intent.getStringExtra(EXTRA_REPOSITORY)
//        val tFollowers = intent.getStringExtra(EXTRA_FOLLOWERS)
//        val tFollowing = intent.getStringExtra(EXTRA_FOLLOWING)


        tvSetName.text = user.name // use (tvSetName.text = tName) instead for non parcelable
        tvSetUsername.text = user.username
        tvSetCompany.text = user.company
        tvSetLocation.text = user.location
        Glide.with(this)
            .load(user.avatar)
            .apply(RequestOptions())
            .into(imgSetAvatar)
        tvSetRepository.text = user.repository
        tvSetFollowers.text = user.follower
        tvSetFollowing.text = user.following


    }
    // this is for non parcelable
//    companion object {
//        const val EXTRA_NAME = "extra_name"
//        const val EXTRA_USERNAME = "extra_username"
//        const val EXTRA_COMPANY = "extra_company"
//        const val EXTRA_LOCATION = "extra_location"
//        const val EXTRA_AVATAR = "extra_avatar"
//        const val EXTRA_REPOSITORY = "extra_repository"
//        const val EXTRA_FOLLOWERS = "extra_followers"
//        const val EXTRA_FOLLOWING = "extra_following"
//    }
    // use this for parcelable
    companion object {
        const val EXTRA_USER = "extra_user"
    }
}
