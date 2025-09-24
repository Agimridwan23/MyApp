package com.example.myapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("TestDebug", "Hello World, ini saya")

        val mShowCount = findViewById<TextView>(R.id.show_count)
        val buttonCountUp = findViewById<Button>(R.id.button_count)
        val buttonToast = findViewById<Button>(R.id.button_toast)
        val buttonSwitchPage = findViewById<Button>(R.id.button_switchpage)
        val buttonBrowser = findViewById<Button>(R.id.button_browser)
        // Open Contacts
        val buttonContact = findViewById<Button>(R.id.button_contact)
        buttonContact.setOnClickListener {
            val intentContact = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("content://contacts/people/")
            }
            startActivity(intentContact)
        }

// Open Maps
        val buttonMaps = findViewById<Button>(R.id.button_maps)
        buttonMaps.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:0,0?q=Bandung")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

// Call Number
        val buttonCall = findViewById<Button>(R.id.button_call)
        buttonCall.setOnClickListener {
            val intentCall = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:081222940650")
            }
            startActivity(intentCall)
        }


        // Count
        buttonCountUp.setOnClickListener {
            mCount++
            mShowCount.text = mCount.toString()
        }

        // Toast
        buttonToast.setOnClickListener {
            val tulisan: String = mShowCount.text.toString()
            val toast = Toast.makeText(this, "Angka yang dimunculkan $tulisan", Toast.LENGTH_LONG)
            toast.show()
        }

        // Explicit Intent (pindah halaman)
        buttonSwitchPage.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        // Implicit Intent (buka browser)
        buttonBrowser.setOnClickListener {
            val intentBrowse = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))
            startActivity(intentBrowse)
        }
    }
}
