package com.example.roomdatabasemvvm.ui.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.roomdatabasemvvm.databinding.ActivityNewWordBinding

class NewWordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewWordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityNewWordBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
    }

    override fun onStart() {
        super.onStart()

        this.binding.buttonSave.setOnClickListener {

            val replyIntent = Intent()

            if(TextUtils.isEmpty(this.binding.editTextWord.text)){
                setResult(Activity.RESULT_CANCELED, replyIntent)
                Toast.makeText(applicationContext, "Nothing added", Toast.LENGTH_LONG).show()
            } else {
                var word = this.binding.editTextWord.text.toString()
                replyIntent.putExtra("REPLY", word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

}