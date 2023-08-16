package com.example.biometricattendance

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AdminDashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dashboard)

        val enterNewEntryButton: Button = findViewById(R.id.enterNewEntryButton)
        val viewEntriesButton: Button = findViewById(R.id.viewEntriesButton)
        val downloadEntriesButton: Button = findViewById(R.id.downloadEntriesButton)

        enterNewEntryButton.setOnClickListener {
            // Start EnterNewEntryActivity
            val intent = Intent(this, EnterNewEntryActivity::class.java)
            startActivity(intent)
        }

        viewEntriesButton.setOnClickListener {
            // Start ViewEntriesActivity
            val intent = Intent(this, ViewEntriesActivity::class.java)
            startActivity(intent)
        }

        downloadEntriesButton.setOnClickListener {
            // Start DownloadEntriesActivity
            val intent = Intent(this, DownloadEntriesActivity::class.java)
            startActivity(intent)
        }
    }
}
