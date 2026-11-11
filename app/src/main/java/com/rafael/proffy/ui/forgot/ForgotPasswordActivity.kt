package com.rafael.proffy.ui.forgot

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.rafael.proffy.R
import com.rafael.proffy.databinding.ActivityForgotPasswordBinding
import com.rafael.proffy.ui.finallyComponent.FinallyActivity

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val enabledColor = ContextCompat.getColor(this, R.color.green)
        val disabledColor = ContextCompat.getColor(this, R.color.shape_disable)

        binding.buttonGoBack.setOnClickListener {
            finish()
        }

        binding.textInputEditEmail.addTextChangedListener {
            val email = it?.toString()?.trim() ?: ""
            val validEmail = isValidEmail(email)

            setButtonState(validEmail, enabledColor, disabledColor)

            if (email.isEmpty() || validEmail) {
                binding.textInputLayoutEmail.error = null
            } else {
                binding.textInputLayoutEmail.error =
                    getString(R.string.forgot_email_error)
            }

            binding.buttonSend.text = if (validEmail) {
                getString(R.string.forgot_button_enabled)
            } else {
                getString(R.string.forgot_button_disabled)
            }
        }

        binding.buttonSend.setOnClickListener {
            val email = binding.textInputEditEmail.text.toString().trim()

            if (isValidEmail(email)) {
                val intent = Intent(this, FinallyActivity::class.java)
                startActivity(intent)
            }
        }

        setButtonState(false, enabledColor, disabledColor)
    }

    private fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() &&
                Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun setButtonState(
        enabled: Boolean,
        enabledColor: Int,
        disabledColor: Int
    ) {
        binding.buttonSend.isEnabled = enabled

        val color = if (enabled) enabledColor else disabledColor
        binding.buttonSend.backgroundTintList = ColorStateList.valueOf(color)

        val textColor = if (enabled) {
            ContextCompat.getColor(this, R.color.shape_01_white)
        } else {
            ContextCompat.getColor(this, R.color.text_complement)
        }

        binding.buttonSend.setTextColor(textColor)
    }
}
