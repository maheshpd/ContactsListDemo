package com.example.contactlistdemo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactlistdemo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // private variable to inflate the layout for the activity
    private lateinit var binding: ActivityMainBinding

    //variable to a access the ViewModel class
    val viewModel : ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inflate the layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //set onClickListener for the floating action button
        binding.floatingActionButton.setOnClickListener{
            val intent = Intent(this,CreateContacts::class.java)
            startActivity(intent)
        }

        // Observe the LiveData returned by the getAllContacts method
        viewModel.getAllContacts().observe(this, Observer { list ->
            binding.recyclerView.layoutManager = LinearLayoutManager(application)
            binding.recyclerView.adapter = ContactsAdapter(this, list)

        })
    }
}