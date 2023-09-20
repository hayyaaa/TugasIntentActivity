package com.example.tugasintentactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.tugasintentactivity.MainActivity.Companion.EXTRA_EMAIL
import com.example.tugasintentactivity.MainActivity.Companion.EXTRA_PHONE
import com.example.tugasintentactivity.MainActivity.Companion.EXTRA_USERNAME
//import com.example.tugasintentactivity.MainActivity.Companion.EXTRA_EMAIL
//import com.example.tugasintentactivity.MainActivity.Companion.EXTRA_PHONE
//import com.example.tugasintentactivity.MainActivity.Companion.EXTRA_USERNAME
import com.example.tugasintentactivity.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    // buat binding
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater) //setting binding
        setContentView(binding.root)

        // mendapat data yg dikirim dari MainActivity
        val username = intent.getStringExtra(EXTRA_USERNAME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val phone = intent.getStringExtra(EXTRA_PHONE)

        with(binding) {
            // yang ditaruh di textview
            txtUsername.text = " $username"
            txtEmail.text = " $email"
            txtPhone.text = " $phone"

            btnLogout.setOnClickListener {
                // membuat Intent untuk kembali ke MainActivity
                val intent = Intent(this@SecondActivity, MainActivity::class.java)

                // memulai aktivitas kembali ke MainActivity
                startActivity(intent)
                finish() // Mengakhiri aktivitas SecondActivity

            }
        }
    }
}