package com.dicoding.picodiploma.githubuserapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvUsers: RecyclerView
    private var list: ArrayList<User> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rv_users)
        rvUsers.setHasFixedSize(true)

        list.addAll(UsersData.listData)
        showRecyclerList()
    }

    private fun showSelectedUser(user: User) {
        val pindahIntentParcelable = Intent(this@MainActivity, DetailActivity::class.java)
        pindahIntentParcelable.putExtra(DetailActivity.EXTRA_USER, user)
        startActivity(pindahIntentParcelable)

//        val pindahIntent = Intent(this@MainActivity, DetailActivity::class.java)
//
//        pindahIntent.putExtra("extra_name",user.name)
//        pindahIntent.putExtra("extra_username",user.username)
//        pindahIntent.putExtra("extra_company",user.company)
//        pindahIntent.putExtra("extra_location",user.location)
//        pindahIntent.putExtra("extra_avatar",user.avatar)
//        pindahIntent.putExtra("extra_repository",user.repository)
//        pindahIntent.putExtra("extra_followers",user.follower)
//        pindahIntent.putExtra("extra_following",user.following)
//        startActivity(pindahIntent)

        Toast.makeText(this, "Membuka " + user.name, Toast.LENGTH_SHORT).show()
    }



    private fun showRecyclerList() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUsers.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {

            override fun onItemClicked(data: User) {
                showSelectedUser(data)

            }
        })
    }
}
