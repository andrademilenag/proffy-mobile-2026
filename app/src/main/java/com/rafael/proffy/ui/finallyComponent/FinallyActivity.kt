package com.rafael.proffy.ui.finallyComponent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rafael.proffy.databinding.ActivityFinallyBinding
import com.rafael.proffy.ui.login.LoginActivity

class FinallyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinallyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFinallyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBackToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)

            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_SINGLE_TOP

            startActivity(intent)
            finish()
        }
    }
}
