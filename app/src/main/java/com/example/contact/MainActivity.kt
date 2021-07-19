package com.example.contact

import Cash.MySharePreferences
import MyAdapters.Adapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var myadapter: Adapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharePreferences.init(this)
        val list = MySharePreferences.obektString

        myadapter = Adapter(this,list)

        binding.contactListView.adapter = myadapter

        binding.contactListView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "$position", Toast.LENGTH_SHORT).show()
        }

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this,RaqamQoshishActivity::class.java))
        }

    }

    override fun onStart() {
        MySharePreferences.init(this)
        val list = MySharePreferences.obektString

        myadapter = Adapter(this,list)

        binding.contactListView.adapter = myadapter

        binding.contactListView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "$position", Toast.LENGTH_SHORT).show()
        }

        super.onStart()
    }

    }
