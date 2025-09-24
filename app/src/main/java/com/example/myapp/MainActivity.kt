package com.example.myapp

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

        // 👉 Logging ditaruh di sini
        Log.d("TestDebug", "Hello World, ini saya")

        val mShowCount = findViewById<TextView>(R.id.show_count)
        val buttonCountUp = findViewById<Button>(R.id.button_count)
        val buttonToast = findViewById<Button>(R.id.button_toast)

        buttonCountUp.setOnClickListener(View.OnClickListener {
            mCount++
            mShowCount.text = mCount.toString()
        })

        buttonToast.setOnClickListener(View.OnClickListener {
            val tulisan: String = mShowCount.text.toString()
            val toast = Toast.makeText(this, "Angka yang dimunculkan $tulisan", Toast.LENGTH_LONG)
            toast.show()
        })
    }
}
