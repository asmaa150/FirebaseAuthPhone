package com.example.firebaseauthphone.base

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<N>:ViewModel(){
     val messageLiveData: MutableLiveData<String>? = null
     val showLoading: MutableLiveData<Boolean>? = null
     var navigator:N?=null
     val context: Context ? = null


}