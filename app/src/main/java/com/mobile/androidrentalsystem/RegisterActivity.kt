package com.mobile.tenantrentalsystem

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mobile.tenantrentalsystem.R
import android.content.Intent
import android.widget.Toast
import com.mobile.tenantrentalsystem.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerButton.setOnClickListener {

            val fullName =
                binding.fullNameEditText.text.toString().trim()

            val email =
                binding.registerEmailEditText.text.toString().trim()

            val password =
                binding.registerPasswordEditText.text.toString()

            if (fullName.isEmpty() ||
                email.isEmpty() ||
                password.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Please fill in all fields",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            Toast.makeText(
                this,
                "Account created. Please log in.",
                Toast.LENGTH_SHORT
            ).show()

            val intent =
                Intent(this, LoginActivity::class.java)

            intent.putExtra("EMAIL", email)

            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP

            startActivity(intent)
        }

        binding.loginLinkTextView.setOnClickListener {
            finish()
        }
    }
}