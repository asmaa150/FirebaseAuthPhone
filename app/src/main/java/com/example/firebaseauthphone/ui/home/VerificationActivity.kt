package com.example.firebaseauthphone.ui.home

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModelProvider
import com.example.firebaseauthphone.R
import com.example.firebaseauthphone.base.BaseActivity
import com.example.firebaseauthphone.databinding.VerificationActivityBinding
import com.example.firebaseauthphone.ui.body.mainHomeActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class VerificationActivity : BaseActivity<VerificationActivityBinding,VerificationViewModel>(),verificationNavigator {
   // var phone_number:String?=null
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       viewdatabinding.items = viewmodel
       viewmodel.navigator = this
    }

    override fun initviewmodel(): VerificationViewModel {
        return ViewModelProvider(this).get(VerificationViewModel::class.java)
    }

    override fun getlayout(): Int {
        return R.layout.verification_activity
    }

    override fun openmainHomeScreen() {
        val intent=Intent(this,mainHomeActivity::class.java)
        startActivity(intent)
    }

}