package com.example.loginandcontacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.loginandcontact.R
import com.google.android.material.textfield.TextInputEditText

val logins: Map<String, String> = mapOf(
    "test@mail.com" to "123456",
    "admin@mail.com" to "Adm**",
    "info@mail.com" to "SomethingSomething"
)

const val INCOMPLETE_DATA = "Please provide a valid user and password first"
const val FAILURE_LOGIN = "Incorrect user or password"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var user = findViewById<TextInputEditText>(R.id.tile_user).text.toString()
        var password = findViewById<TextInputEditText>(R.id.tile_password).text.toString()

        findViewById<Button>(R.id.mb_login).setOnClickListener {

            if (user.isNullOrEmpty() or password.isNullOrEmpty())
                Toast.makeText(this, INCOMPLETE_DATA, Toast.LENGTH_LONG).show() else
            {
                if (logins.containsKey(user).run {
                    logins[user].equals(password)
                    })
                    startActivity(Intent(this,MusicContacts::class.java)).also {
                        finish()
                    } else {
                        Toast.makeText(this, FAILURE_LOGIN, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}