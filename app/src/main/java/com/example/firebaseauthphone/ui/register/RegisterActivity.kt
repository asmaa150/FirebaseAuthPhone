package com.example.firebaseauthphone.ui.register

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.firebaseauthphone.R
import com.example.firebaseauthphone.base.BaseActivity
import com.example.firebaseauthphone.databinding.RegisterBinding
import com.example.firebaseauthphone.ui.home.VerificationActivity

class RegisterActivity : BaseActivity<RegisterBinding, RegisterViewModel>(),registerNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewdatabinding.vm = viewmodel
        viewmodel.navigator = this

    }

    override fun initviewmodel(): RegisterViewModel {
      return  ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    override fun getlayout(): Int {
        return R.layout.register
    }

    override fun openVerifyCodeActivity() {
        val intent= Intent(this,VerificationActivity::class.java)
        intent.putExtra("mobile","+201289072533")
        startActivity(intent)
    }


}