package com.example.biometricattendance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EnterNewEntryActivity : AppCompatActivity() {

    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    // ... other views

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_new_entry)

        firstNameEditText = findViewById(R.id.firstNameEditText)
        lastNameEditText = findViewById(R.id.lastNameEditText)
        // ... initialize other views

        val saveEntryButton: Button = findViewById(R.id.saveEntryButton)
        saveEntryButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch{
                saveEntry()
            }
        }
    }

    private suspend fun saveEntry() {
        val firstName = firstNameEditText.text.toString()
        val lastName = lastNameEditText.text.toString()

        // Create an Entry object and save it to the Room database
        val entry = Entry(0,firstName, lastName)
        val entryDao = AppDatabase.getInstance(applicationContext).entryDao()
        entryDao.insert(entry)

        // Optional: Show a toast message to indicate successful entry
        Toast.makeText(this, "Entry saved successfully", Toast.LENGTH_SHORT).show()

        // Finish the activity or navigate to another screen
        finish()
    }
}
