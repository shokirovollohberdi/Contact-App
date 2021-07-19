package com.example.contact

import Cash.MySharePreferences
import Models.User
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contact.databinding.ActivityRaqamQoshishBinding

class RaqamQoshishActivity : AppCompatActivity() {
    lateinit var binding: ActivityRaqamQoshishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRaqamQoshishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharePreferences.init(this)

        binding.btnSave.setOnClickListener {
            val name = binding.edtIsm.text.toString().trim()
            val number = binding.edtRaqam.text.toString().trim()

            if (name != "" && number != "") {
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                val list = MySharePreferences.obektString
                list.add(User(name, number))
                MySharePreferences.obektString = list
                finish()
            } else {
                Toast.makeText(this, "Ma'lumotlar yetarli emas", Toast.LENGTH_SHORT).show()
            }

        }

    }
}