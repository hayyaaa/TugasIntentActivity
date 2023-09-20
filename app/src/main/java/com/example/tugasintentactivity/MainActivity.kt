package com.example.tugasintentactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tugasintentactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivityLifeCycle"

    // buat binding dulu
    private lateinit var binding : ActivityMainBinding

    // untuk mengirim data dr activity1 ke activity2 harus membuat key\
    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //setting biniding
        setContentView(binding.root)

        with(binding) {
            btnRegister.setOnClickListener {
                // membuat Intent untuk berpindah ke SecondActivity
                val intentToSecondActivity = Intent(this@MainActivity, SecondActivity::class.java)

                // untuk memanggil username di activity2
                val username = editTxtUsername.text.toString()
                intentToSecondActivity.putExtra(EXTRA_USERNAME,username)

                // untuk memanggil email di activity2
                val email = editTxtEmail.text.toString()
                intentToSecondActivity.putExtra(EXTRA_EMAIL,email)

                // untuk memanggil phone di activity2
                val phone = editTxtPhone.text.toString()
                intentToSecondActivity.putExtra(EXTRA_PHONE,phone)

                // memulai aktivitas kedua
                startActivity(intentToSecondActivity)

            }
        }

        Log.d(TAG, "inCreate dipanggil")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume dipanggil")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause dipanggil")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy dipanggil")
    }
}