package com.example.alldocumentreader.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alldocumentreader.MainActivity
import com.example.alldocumentreader.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private var binding:ActivitySplashScreenBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.imageVSplashScreen?.alpha = 0f
        binding?.imageVSplashScreen?.animate()?.setDuration(1500)?.alpha(1f)?.withEndAction{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}