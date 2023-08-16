package com.example.biometricattendance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var roleText: TextView
    private lateinit var adminButton: Button
    private lateinit var userButton: Button
    private lateinit var adminLayout: LinearLayout
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        roleText = findViewById(R.id.roleText)
        adminButton = findViewById(R.id.adminButton)
        userButton = findViewById(R.id.userButton)
        adminLayout = findViewById(R.id.adminLayout)
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
    }

    fun onAdminClick(view: View) {
        roleText.visibility = View.GONE
        adminButton.visibility = View.GONE
        userButton.visibility = View.GONE
        adminLayout.visibility = View.VISIBLE
    }

    fun onLoginClick(view: View) {
        val enteredUsername = usernameEditText.text.toString()
        val enteredPassword = passwordEditText.text.toString()

        // Check admin credentials
        if (enteredUsername == "test123" && enteredPassword == "12345") {
            // Perform admin-specific actions here
            Toast.makeText(this, "Admin login successful!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, AdminDashboardActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
        }
    }

    fun onUserClick(view: View) {
        // Handle User role click (if needed)
    }
}
