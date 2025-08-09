package com.example.constraintlayout

import android.os.Bundle
import android.text.Editable
import android.util.Patterns
import android.widget.EditText
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContentView(R.layout.activity_sign_in)

        val emailEditText = findViewById<EditText>(R.id.emailEditText)

        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed for this use case
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Not needed for this use case
            }

            override fun afterTextChanged(s: Editable?) {
                val email = s.toString()
                if (isValidEmail(email)) {
                    // Show the checkmark icon
                    emailEditText.setCompoundDrawablesWithIntrinsicBounds(
                        0, 0, R.drawable.correct, 0
                    )
                } else {
                    // Hide the icon
                    emailEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
                }
            }
        })
    }

    // A simple function to validate email format
    private fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}