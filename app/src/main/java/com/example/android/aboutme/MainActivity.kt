package com.example.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

//    lateinit var btnDone: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        btnDone = findViewById(R.id.done_btn)
//        btnDone.setOnClickListener { addNickname(it) }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.doneBtn.setOnClickListener { addNickname(it) }
    }

    private fun addNickname(view: View){
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
//
//        nicknameTextView.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nicknameTextView.visibility = View.VISIBLE

        binding.apply {
            nicknameText.text = nicknameEdit.text
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneBtn.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }


        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}