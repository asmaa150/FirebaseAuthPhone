package com.example.firebaseauthphone.ui.register

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.firebaseauthphone.base.BaseViewModel
import com.hbb20.CountryCodePicker

class RegisterViewModel :BaseViewModel<registerNavigator>() {
    val firstname = ObservableField<String>();
    val firstnameError = ObservableField<String>();
    val lastname = ObservableField<String>();
    val lastnameError = ObservableField<String>();
    val username = ObservableField<String>();
    val usernameError = ObservableField<String>();
    val phone = ObservableField<String>();
    val phoneError = ObservableField<String>();

    fun createAccount() {
        if(isValidation()){
            showLoading?.value=true
        navigator?.openVerifyCodeActivity()}

    }
    var isvalid = true
    fun isValidation(): Boolean {
        if (firstname.get().isNullOrBlank()) {
            firstnameError.set("please enter first name")
            isvalid = false
        } else {
            firstnameError.set(null)
        }
        if (lastname.get().isNullOrBlank()) {
            lastnameError.set("please enter last name")
            isvalid = false
        } else {
            lastnameError.set(null)
        }

        if (username.get().isNullOrBlank()) {
            usernameError.set("please enter user name")
            isvalid = false
        } else {
            usernameError.set(null)
        }
        if (phone.get().isNullOrBlank()) {
            phoneError.set("please enter phone")
            isvalid = false; } else {
            phoneError.set(null)
        }

        return isvalid
    }

}

