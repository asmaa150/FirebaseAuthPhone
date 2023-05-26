package com.example.firebaseauthphone.ui.body

import androidx.lifecycle.ViewModelProvider
import com.example.firebaseauthphone.R
import com.example.firebaseauthphone.base.BaseActivity
import com.example.firebaseauthphone.databinding.VerificationActivityBinding

class mainHomeActivity:BaseActivity<VerificationActivityBinding,mainHomeViewModel>() {
    override fun initviewmodel(): mainHomeViewModel {
        return ViewModelProvider(this).get(mainHomeViewModel::class.java)
    }

    override fun getlayout(): Int {
        return R.layout.maimhome_activity
    }
}