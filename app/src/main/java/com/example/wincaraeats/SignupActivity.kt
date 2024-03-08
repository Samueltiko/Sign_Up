package com.example.wincaraeats

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class SignupActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //Initialize the DatabaseHelper
        databaseHelper = DatabaseHelper(this)


    }
}